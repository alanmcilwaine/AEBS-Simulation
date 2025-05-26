package com.fixit.car.sensors;

import com.fixit.aebs.Aebs;
import com.fixit.simulation.Weather;

/** 
* Sensor for sending lidar
* distance data to other packages
*/
public class Lidar implements DistanceSensor {
  /**
   * Sends distance information to AEBS package
   * 
   * @param sensor An enum representing the sensors type
   * @param data distance value to be sent
   * @param weather An enum representing weather status
   */
  @Override
  public void sendToAEBS(final SensorType sensor, final Double data, final Weather weather) {
    Aebs.instance().receiveDistanceAebs(data);
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
  public int readData(final SensorType sensor, final Double data, final Weather weather) {
    sendToAEBS(sensor, data, weather);
    return 1;
  }
}
