package com.fixit.controlsignal;

import com.fixit.car.sensors.SensorType;

interface ControlSignal {
  /**
   * Takes a given car sensor, and processes the data in it.
   * For example, if the sensor holds data related to Speed, this data will be
   * sent to the Car and applied. The brake power will be sent to the AEBS.
   *
   * @param sensor The car sensor of interest, that holds the data.
   * @param power The brake power to apply to the car.
   */
  void processSensorData(SensorType sensor, double power);

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
