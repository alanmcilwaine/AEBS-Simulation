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
    boolean out = lidarSensors.stream()
            .allMatch(s -> s.data() > 0);
    if (!out) {
      return false;
    }
    boolean allSame = lidarSensors.stream()
            .map(Lidar::data)
            .distinct()
            .count() == 1;
    if (!allSame) {
      UserInterface.receiveWarning("Lidar sensors have different data.");
    }
    lidarSensors.forEach(c -> c.data(0));
    return true;
  }

  @Override
  public void tick() {
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
      case SensorType.LIDARCENTRE -> {
        assert lidarSensors.get(1) != null;
        Lidar lidar = lidarSensors.get(1);
        lidar.data(signal);
        if (allLidarHasValues()) {
          lidar.readData(sensor, signal, weather);
        }
      }
      case SensorType.LIDARLEFT -> {
        assert lidarSensors.getFirst() != null;
        Lidar lidar = lidarSensors.getFirst();
        lidar.data(signal);
        if (allLidarHasValues()) {
          lidar.readData(sensor, signal, weather);
        }
      }
      case SensorType.LIDARRIGHT -> {
        assert lidarSensors.get(2) != null;
        Lidar lidar = lidarSensors.get(2);
        lidar.data(signal);
        if (allLidarHasValues()) {
          lidar.readData(sensor, signal, weather);
        }
      }
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
