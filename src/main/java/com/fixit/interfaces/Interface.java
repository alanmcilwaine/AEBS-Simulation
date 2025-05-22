package com.fixit.interfaces;

/**
 * Public API access to Interface (UI)
 * Does stuff
 */
public interface Interface {
  /**
   * receiveSpeed method gets called by sensor
   * package and then displays speed to the user.
   *
   * @param speed is the unit of measurement (kph) that will be
   * displayed to the user.
   */
  void receiveSpeed(double speed);
}
