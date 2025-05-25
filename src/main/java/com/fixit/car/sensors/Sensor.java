package com.fixit.car.sensors;

import com.fixit.simulation.Weather;

/**
 * Middleman handler of data distribution
 * from sensor classes.
*/
public interface Sensor {
  /**
   * @param sensor An enum representing the sensors type
   * @param data Value to be handled and sent
   * @param weather An enum representing weather status
   * @return 1 if successful
   */
  int readData(final SensorType sensor, final Double data, final Weather weather);
}