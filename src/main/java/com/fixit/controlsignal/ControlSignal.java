package com.fixit.controlsignal;

import com.fixit.car.sensors.SensorType;

interface ControlSignal {
  /**
   * The sensor data that will be processed will be the speed of the wheels,
   * which will be sent to the car.
   *
   * @param sensorType The type of car sensor that we will be processing.
   *                   In this context, it will likely be the Wheel Speeds.
   * @param speed The current speed as detected by the sensors. This will be
   *              in kilometers per hour. (km/h.)
   */
  void processSensorData(SensorType sensorType, double speed);

  /**
   * Processes user input.
   *
   * @param action The action that the car brakes will take.
   * @param power The brake power to apply to the car.
   */
  void processUserInput(Action action, double power);

  /** Activates the Anti-lock Brake system. */
  default void triggerAntiLockBrake() {
    /* NB: Placeholder values are used here. */
  }

  /** Make an action! (Not sure what it does at this stage). */
  void makeAnAction();
}
