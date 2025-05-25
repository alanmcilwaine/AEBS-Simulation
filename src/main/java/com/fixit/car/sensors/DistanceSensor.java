package com.fixit.car.sensors;

import com.fixit.simulation.Weather;

/** */
public interface DistanceSensor extends Sensor {
  /**
   * @return
   */
  void sendToAEBS(SensorType sensor, Double data, Weather weather);
}
