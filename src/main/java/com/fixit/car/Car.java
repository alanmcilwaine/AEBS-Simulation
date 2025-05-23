package com.fixit.car;

import com.fixit.car.sensors.Sensor;
import com.fixit.car.sensors.SensorType;
import com.fixit.controlsignal.ControlSignals;
import com.fixit.interfaces.Interface;
import com.fixit.interfaces.UserInterface;
import com.fixit.simulation.Weather;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;

/**
 * Car holds the functionality for the system. It contains sensors,
 * control signals, the AEBS and interface.
 */
public final class Car implements Vehicle {
  interface MockSensor extends Sensor {
    void readData(SensorType sensor, double data, Weather weather);
  }

  /**
   * Car Interface.
   */
  private final Interface ui = new UserInterface();
  /**
   * Control signals in the car to determine whether to brake.
   */
  private final ControlSignals controlSignal = new ControlSignals();
  /**
   * 3 radar sensors in the car.
   */
  private final List<MockSensor> radarSensors = new ArrayList<>();
  /**
   * 3 lidar sensors in the car.
   */
  private final List<MockSensor> lidarSensors = new ArrayList<>();
  /**
   * 3 wheel speed sensors in the car.
   */
  private final List<MockSensor> wheelSpeedSensors = new ArrayList<>();
  /**
   * 3 camera sensors in the car.
   */
  private final List<MockSensor> cameraSensors = new ArrayList<>();

  private Car() {
    assert !wheelSpeedSensors.isEmpty() : "No wheel speed sensors";
    assert !cameraSensors.isEmpty() : "No camera sensors sensors";
    assert !lidarSensors.isEmpty() : "No lidar sensors sensors";
    assert !radarSensors.isEmpty() : "No radar sensors sensors";
    Timer timer = new Timer(1, (unused) -> tick());
    timer.start();
  }

  /**
   * Instance of car.
   */
  private static final Car INSTANCE = new Car();

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

  @Override
  public void tick() {
  }

  @Override
  public void sensorInput(final SensorType sensor, final double signal,
                         final Weather weather) {
    assert sensor != null;
    assert signal >= 0;

    switch (sensor) {
      case SensorType.RADAR ->
        radarSensors.forEach(s -> s.readData(sensor, signal, weather));
      case SensorType.LIDARCENTRE ->
        lidarSensors.get(1).readData(sensor, signal, weather);
      case SensorType.LIDARLEFT ->
        lidarSensors.get(0).readData(sensor, signal, weather);
      case SensorType.LIDARRIGHT ->
        lidarSensors.get(2).readData(sensor, signal, weather);
      case SensorType.CAMERA ->
        cameraSensors.forEach(s -> s.readData(sensor, signal, weather));
      case SensorType.WHEELSPEEDLEFT ->
        wheelSpeedSensors.get(0).readData(sensor, signal, weather);
      case SensorType.WHEELSPEEDRIGHT ->
        wheelSpeedSensors.get(1).readData(sensor, signal, weather);
      default -> {
        throw new IllegalArgumentException("Unsupported sensor: " + sensor);
      }
    }
  }
}
