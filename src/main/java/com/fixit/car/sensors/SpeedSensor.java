package com.fixit.car.sensors;

import com.fixit.simulation.Weather;

/** */
public interface SpeedSensor extends Sensor {
  /**
   * @return
   */
  void sendToControlSignal(final SensorType sensor, final Double data);

  /**
   * @return
   */
  void sendToInterface(final Double data);

  /**
   * @return
   */
  void sendToAEBS(final SensorType sensor, final Double data, final Weather weather);
}
