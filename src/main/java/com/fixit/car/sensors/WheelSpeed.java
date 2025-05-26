package com.fixit.car.sensors;

import com.fixit.aebs.Aebs;
import com.fixit.controlsignal.ControlSignals;
import com.fixit.interfaces.UserInterface;
import com.fixit.simulation.Weather;

/**
 *
 *
 *
 *
 */
public class WheelSpeed implements SpeedSensor {

  @Override
  public void sendToControlSignal(final SensorType sensor, final Double data) {
    ControlSignals.cs().processSensorSpeed(sensor, data);
  }

  @Override
  public void sendToInterface(final Double data) {
    UserInterface.receiveSpeed(data);
  }

  @Override
  public void sendToAEBS(final SensorType sensor, final Double data, final Weather weather) {
    Aebs.instance().receiveSpeedAebs(data);
  }

  @Override
  public int readData(final SensorType sensor, final Double data, final Weather weather) {
    sendToAEBS(sensor, data, weather);
    sendToControlSignal(sensor, data);
    sendToInterface(data);
    return 1;
  }

}
