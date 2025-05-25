package com.fixit.controlsignal;

import com.fixit.car.sensors.SensorType;

interface ControlSignal {
  /**
   * Processes data from the Wheel Speed Sensors; the data will be sent to the
   * car.
   *
   * @param sType The type of car sensor that we will be processing.
   *                   In this context, it will be the Wheel Speed Sensors.
   * @param wSpeed The current speed as detected by the sensors. This will be
   *              in kilometers per hour. (km/h or kph.)
   */
  void processSensorSpeed(SensorType sType, double wSpeed);

  /**
   * Processes the power of the brakes that will be applied. This involves
   * sending this value to the car.
   *
   * @param action The action that the car brakes will take.
   * @param bPower The brake power to apply to the car.
   */
  void processBrakePower(Action action, double bPower);

  /** Activates the Anti-lock Brake system. */
  default void triggerAntiLockBrake() {
    /* todo: Implement if time allows. */
  }
}
