package com.fixit.car.sensors;

import com.fixit.simulation.Weather;

/** */
public interface SpeedSensor extends Sensor {
  /**
   * @return
   */
  void sendToControlSignal(SensorType sensor, Double data);

  /**
   * @return
   */
  void sendToInterface(Double data);

  /**
   * @return
   */
  void sendToAEBS(SensorType sensor, Double data, Weather weather);
}
