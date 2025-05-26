package com.fixit.car.sensors;

import com.fixit.simulation.Weather;
/** 
 * Unsupported class.
 * 
 * Sensor for sending radar
 * distance data to other packages
*/
public class Radar implements DistanceSensor {
  /**
   * Unsupported method.
   * 
   * Sends distance information to AEBS package
   * 
   * @param sensor An enum representing the sensors type
   * @param data distance value to be sent
   * @param weather An enum representing weather status
   */
  @Override
  public void sendToAEBS(final SensorType sensor,
                         final Double data,
                         final Weather weather) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  /**
   * Facilitates distance data 
   * distribution with sendToAEBS()
   * 
   * @param sensor An enum representing the sensors type
   * @param data Distance value to be sent
   * @param weather An enum representing weather status
   * @return 1 if successful
   */
  @Override
  public int readData(final SensorType sensor,
                      final Double data,
                      final Weather weather) {
    sendToAEBS(sensor, data, weather);
    return 1;
  }
}
