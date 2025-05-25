package com.fixit.car.sensors;

import com.fixit.simulation.Weather;

/** */
public interface DistanceSensor extends Sensor {
  /**
   * @return
   */
  void sendToAEBS(final SensorType sensor, final Double data, final Weather weather);
}
