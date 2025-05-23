package com.fixit.car;

import com.fixit.car.sensors.SensorType;
import com.fixit.simulation.Weather;

/**
 * Public API to access the Vehicle (Car).
 * The simulation calls {@link #sensorInput(SensorType, double, Weather)}
 * to send data to the vehicle.
 *
 */

public interface Vehicle {
  /**
   * Tick will consistently call methods inside the sensors.
   * This method might be irrelevant but will be nice if we need a tick.
   */
  void tick();

  /**
   * Receives input from the simulation to send data to different sensors.
   *
   * @param sensor The specific sensor which will receive the data.
   * @param signal The stream of data for the sensor to interpret.
   * @param weather The weather pattern to be considered to make a decision.
   */
  void sensorInput(SensorType sensor, double signal, Weather weather);
}
