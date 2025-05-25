package com.fixit.car.sensors;

import com.fixit.aebs.Aebs;
import com.fixit.simulation.Weather;

/** */
public class Lidar implements DistanceSensor {

  @Override
  public void sendToAEBS(final SensorType sensor, final Double data, final Weather weather) {
    Aebs.instance().receiveDistanceAebs(data);
  }

  @Override
  public int readData(final SensorType sensor, final Double data, final Weather weather) {
    sendToAEBS(sensor, data, weather);
    return 1;
  }
}
