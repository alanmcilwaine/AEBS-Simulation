package com.fixit.interfaces;

/**
 * Public API access to Interface (UI).
 * Does stuff
 */
public interface Interface {
  /**
   * receiveSpeed method gets called by sensor package
   * and then displays speed to the user.
   *
   * @param speed is the unit of measurement (kph)
   *              that will be displayed to the user.
   */
  static void receiveSpeed(double speed) {

  }

  /**
   * receiveWarning method gets called by ControlSignal
   * package when there is a warning that needs to be
   * displayed to the driver. This can be anything such
   * as ABS being triggered, AutoBrakeSystem being triggered, or
   * enabled/disabled.
   *
   * @param warning is the warning object that gets passed from ControlSignal that gets displayed to the user.
   */
  static void receiveWarning(String warning) {

  }
}
