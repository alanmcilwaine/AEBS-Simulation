package com.fixit.car;

import com.fixit.car.sensors.Camera;
import com.fixit.car.sensors.Lidar;
import com.fixit.car.sensors.Radar;
import com.fixit.car.sensors.SensorType;
import com.fixit.car.sensors.WheelSpeed;
import com.fixit.interfaces.UserInterface;
import com.fixit.simulation.Weather;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Car holds the functionality for the system. It contains sensors,
 * control signals, the Aebs and interface.
 */
public final class Car implements Vehicle {
  /**
   * Car speed.
   */
  private double speed = 0;
  /**
   * Upper bound in for loops.
   */
  public static final int UPPERBOUND = 10;
  /**
   * 3 radar sensors in the car.
   */
  private final List<Radar> radarSensors = new ArrayList<>();
  /**
   * 3 lidar sensors in the car.
   */
  private final List<Lidar> lidarSensors = new ArrayList<>();
  /**
   * 3 wheel speed sensors in the car.
   */
  private final List<WheelSpeed> wheelSpeedSensors = new ArrayList<>();
  /**
   * 3 camera sensors in the car.
   */
  private final List<Camera> cameraSensors = new ArrayList<>();

  private Car() {
    radarSensors.addAll(List.of(new Radar(), new Radar(), new Radar()));
    lidarSensors.addAll(List.of(new Lidar(), new Lidar(), new Lidar()));
    cameraSensors.addAll(List.of(new Camera(), new Camera(), new Camera()));
    wheelSpeedSensors.addAll(List.of(new WheelSpeed(), new WheelSpeed()));
    new UserInterface();
  }

  /**
   * Instance of car.
   */
  private static final Car INSTANCE;

  static {
    INSTANCE = new Car();
  }

  /**
   * Singleton pattern of Car. There should only be
   * one car in existence. Call this method when you want
   * to access the car.
   *
   * @return Car instance.
   */
  public static Car instance() {
    return INSTANCE;
  }

  /**
   * Change speed value of the car. (km/h)
   * This is changed by the ControlSignals.
   *
   * @param newSpeed New km/h value of the car.
   */
  public void speed(final double newSpeed) {
    this.speed = newSpeed;
  }

  /**
   * Getter for speed.
   *
   * @return The speed of the car.
   */
  public double speed() {
    return this.speed;
  }

  /**
   * Check if all lidar sensors have a value.
   *
   * @return True if all values are set, otherwise false.
   */
  public boolean allLidarHasValues() {
    final int lidarSensorCount = 3;
    assert !lidarSensors.isEmpty();
    while (lidarSensors.size() != lidarSensorCount) {
      lidarSensors.add(new Lidar());
    }
    if (lidarSensors.stream().anyMatch(s -> s.data() == -1)) {
      return false;
    }
    return lidarSensors.stream().anyMatch(s -> s.data() != -1);
  }

  @Override
  public void tick() {
  }

  /**
   * Removing a lidar. Used by the test.
   *
   * @param index Which lidar to remove, 0,1,2.
   */
  public void testRemoveLidar(final int index) {
    lidarSensors.remove(index);
  }

  /**
   * Method for handling the 2oo3 portion of LIDAR sensor.
   *
   * @param sensor Specific sensor type of the lidar.
   * @param index Index in the lidarSensors for the specific lidar.
   * @param signal Signal strength.
   * @param weather Weather pattern.
   */
  public void handleLidar(final SensorType sensor, final int index,
                          final double signal, final Weather weather) {
    assert lidarSensors.get(index) != null;
    assert signal >= 0;
    Lidar lidar = lidarSensors.get(index);
    lidar.data(signal);
    if (allLidarHasValues()) {
      // Determine 2oo3.
      Optional<Double> votedValue = votedLidarValue();
      votedValue.ifPresent(value -> lidar.readData(sensor, value, weather));
      for (int i = lidarSensors.size() - 1; i >= 0; i--) {
        if (lidarSensors.get(i).incorrectCounter() == 3) {
          UserInterface.receiveWarning("Lidar is incorrect 3 times. "
                  + "Removing and adding new one.");
          lidarSensors.remove(i);
          allLidarHasValues();
        }
      }
      // Reset lidar values.
      lidarSensors.forEach(c -> c.data(-1));
      UserInterface.tick();
    }
  }

  private Optional<Double> votedLidarValue() {
    final double tolerance = 0.1;
    final int requiredMajority = 2;
    // Group sensor output to show if majority. e.g
    // <0.5, 2> <100, 1>. This output implies 2 sensors had 0.5 input.
    Map<Double, Long> values = lidarSensors.stream()
            .map(Lidar::data)
            .collect(Collectors.groupingBy(
                    d -> roundToTolerance(d, tolerance),
                    Collectors.counting()
            ));
    // This will add how many times the sensor has been incorrect.
    for (Map.Entry<Double, Long> entry : values.entrySet()) {
      if (entry.getValue() != 1) {
        continue;
      }
      for (Lidar lidar : lidarSensors) {
        if (lidar.data() == entry.getKey()) {
          lidar.addIncorrectCounter();
        }
      }
    }
    // Return an optional indicating the accepted value, OR empty on failure.
    return values.entrySet().stream()
            .filter(e -> e.getValue() >= requiredMajority)
            .map(e -> Optional.of(e.getKey()))
            .findFirst()
            .orElseGet(() -> {
              UserInterface.receiveWarning("2oo3 failed. Lidar do not agree.");
              return Optional.empty();
            });
  }

  private double roundToTolerance(final double value, final double tolerance) {
    return Math.round(value / tolerance) * tolerance;
  }

  @Override
  public void sensorInput(final SensorType sensor, final double signal,
                         final Weather weather) {
    assert sensor != null;
    assert signal >= 0;

    switch (sensor) {
      case SensorType.RADAR -> {
        for (int i = 0; i < radarSensors.size() && i < UPPERBOUND; i++) {
          radarSensors.get(i).readData(sensor, signal, weather);
        }
      }
      case SensorType.LIDARCENTRE -> handleLidar(SensorType.LIDARCENTRE, 1,
              signal, weather);
      case SensorType.LIDARLEFT -> handleLidar(SensorType.LIDARLEFT, 0,
              signal, weather);
      case SensorType.LIDARRIGHT -> handleLidar(SensorType.LIDARRIGHT, 2,
              signal, weather);
      case SensorType.CAMERA -> {
        for (int i = 0; i < cameraSensors.size() && i < UPPERBOUND; i++) {
          cameraSensors.get(i).readData(sensor, signal, weather);
        }
      }
      case SensorType.WHEELSPEEDLEFT -> {
        assert wheelSpeedSensors.getFirst() != null;
        wheelSpeedSensors.getFirst().readData(sensor, signal, weather);
      }
      case SensorType.WHEELSPEEDRIGHT -> {
        assert wheelSpeedSensors.get(1) != null;
        wheelSpeedSensors.get(1).readData(sensor, signal, weather);
      }
      default -> throw new IllegalArgumentException("" + sensor);
    }
  }
}
