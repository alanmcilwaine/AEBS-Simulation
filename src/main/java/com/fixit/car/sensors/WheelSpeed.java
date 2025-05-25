package com.fixit.car.sensors;

import com.fixit.aebs.Aebs;
import com.fixit.controlsignal.ControlSignals;
import com.fixit.interfaces.UserInterface;
import com.fixit.simulation.Weather;

/** */
public class WheelSpeed implements SpeedSensor {

  @Override
  public void sendToControlSignal(SensorType sensor, Double data) {
    ControlSignals.cs().processSensorData(sensor, data);
  }

  @Override
  public void sendToInterface(Double data) {
    UserInterface.receiveSpeed(data);
  }

  @Override
  public void sendToAEBS(SensorType sensor, Double data, Weather weather) {
    Aebs.instance().receiveSpeedAebs(data);
  }

  @Override
  public int readData(SensorType sensor, Double data, Weather weather) {
    sendToControlSignal(sensor, data);
    sendToInterface(data);
    return 1;
  }
}
