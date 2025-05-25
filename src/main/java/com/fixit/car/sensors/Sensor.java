package com.fixit.car.sensors;

import com.fixit.simulation.Weather;

/** */
public interface Sensor {
  /**
   * @param sensor
   * @param data
   * @return depends on success
   */
  int readData(final SensorType sensor, final Double data, final Weather weather);
}