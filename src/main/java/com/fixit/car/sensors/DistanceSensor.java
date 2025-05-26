package com.fixit.car.sensors;

import com.fixit.simulation.Weather;

/** 
 * Specific middleman for
 * sensors that handle distance.
*/
public interface DistanceSensor extends Sensor {
   /**
   * Sends distance information to AEBS package
   * 
   * @param sensor An enum representing the sensors type
   * @param data Distance value to be sent
   * @param weather An enum representing weather status
   */
  void sendToAEBS(final SensorType sensor,
                  final Double data,
                  final Weather weather);
}
