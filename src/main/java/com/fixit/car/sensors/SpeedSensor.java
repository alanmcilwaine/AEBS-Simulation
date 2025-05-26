package com.fixit.car.sensors;

import com.fixit.simulation.Weather;

/** 
 * Specific middleman for
 * sensors that handle speed.
*/
public interface SpeedSensor extends Sensor {
  /**
   * Sends speed information to ControlSignal package
   * 
   * @param sensor An enum representing the sensors type
   * @param data value to be sent
   */
  void sendToControlSignal(final SensorType sensor, final Double data);

  /**
   * Sends speed information to Interface package
   * 
   * @param data value to be sent
   */
  void sendToInterface(final Double data);

  /**
   * Sends speed information to AEBS package
   * 
   * @param sensor An enum representing the sensors type
   * @param data speed value to be sent
   * @param weather An enum representing weather status
   */
  void sendToAEBS(final SensorType sensor, final Double data, final Weather weather);
}
