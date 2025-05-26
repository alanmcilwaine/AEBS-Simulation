package com.fixit.car.sensors;

import com.fixit.aebs.Aebs;
import com.fixit.controlsignal.ControlSignals;
import com.fixit.interfaces.UserInterface;
import com.fixit.simulation.Weather;


/** 
 * Sensor for sending wheel
 * speed data to other packages
*/
public class WheelSpeed implements SpeedSensor {
  /**
   * Sends speed information to ControlSignal package
   * 
   * @param sensor An enum representing the sensors type
   * @param data speed value to be sent (kmh)
   */
  @Override
  public void sendToControlSignal(final SensorType sensor,
                                  final Double data) {
    ControlSignals.cs().processSensorSpeed(sensor, data);
  }


  /**
   * Sends speed information to Interface package
   * 
   * @param data speed value to be sent (kmh)
   */
  @Override
  public void sendToInterface(final Double data) {
    UserInterface.receiveSpeed(data);
  }

  /**
   * Sends speed information to AEBS package
   * 
   * @param sensor An enum representing the sensors type
   * @param data speed value to be sent (kmh)
   * @param weather An enum representing weather status
   */
  @Override
  public void sendToAEBS(final SensorType sensor,
                         final Double data,
                         final Weather weather) {
    Aebs.instance().receiveSpeedAebs(data);
  }

  /**
   * Facilitates data distribution and
   * handles data conversion from rpm to kmh
   * 
   * @param sensor An enum representing the sensors type
   * @param data Value to be handled and sent (rpm)
   * @param weather An enum representing weather status
   * @return 1 if successful
   */
  @Override
  public int readData(final SensorType sensor,
                      final Double data,
                      final Weather weather) {
    // Convert data (rpm) to dataKmh (kmh)
    if (data <= 0) { return 0; }
    Double dataKmh = (3.0/25.0)*Math.PI*0.25*data;
    sendToControlSignal(sensor, dataKmh);
    sendToInterface(dataKmh);
    sendToAEBS(sensor, dataKmh, weather);
    return 1;
  }
}
