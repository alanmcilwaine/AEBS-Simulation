package com.fixit.car;

import com.fixit.car.sensors.SensorType;

/**
 * Car holds the functionality for the system. It contains sensors,
 * control signals, the AEBS and interface.
 */
public final class Car implements Vehicle {
  // Define the variables here

  private Car() {
    // Define the sensors here
    // Define the control signal here
    // Define the interface here
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
  public int sensorInput(final SensorType sensor, final double signal) {
    // Send data to the sensor.
    return 0;
  }
}
