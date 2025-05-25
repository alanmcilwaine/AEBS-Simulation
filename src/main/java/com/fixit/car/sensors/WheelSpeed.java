package com.fixit.car.sensors;

import com.fixit.aebs.Aebs;
import com.fixit.controlsignal.ControlSignals;
import com.fixit.interfaces.UserInterface;
import com.fixit.simulation.Weather;

/** */
public class WheelSpeed implements SpeedSensor {

  @Override
  public void sendToControlSignal(final SensorType sensor, final Double data) {
    ControlSignals.cs().processSensorData(sensor, data);
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
    // Convert data (rpm) to dataKmh (kmh)
    Double dataKmh = (3/25)*Math.PI*0.25*data;
    sendToControlSignal(sensor, dataKmh);
    sendToInterface(dataKmh);
    sendToAEBS(sensor, dataKmh, weather);
    return 1;
  }
}
