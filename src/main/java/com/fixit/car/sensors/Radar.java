package com.fixit.car.sensors;

import com.fixit.simulation.Weather;

/** */
public class Radar implements DistanceSensor {

  @Override
  public void sendToAEBS(final SensorType sensor, final Double data, final Weather weather) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public int readData(final SensorType sensor, final Double data, final Weather weather) {
    sendToAEBS(sensor, data, weather);
    return 1;
  }
}
