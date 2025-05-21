package com.fixit.interfaces;

/**
 * Public API access to Interface (UI)
 *
 */
public interface Interface {
  /**
   * autoSystemToggle method calls controlSignal to
   * enable or disable the Automatic Emergency Braking system.
   * Returns void, but tells the user the state
   * of the system (on or off)
   */
  void autoSystemToggle();

  /**
   * applyBrake method calls controlSignal to apply the amount
   * of brakes specified by the driver to slow down.
   * Returns void.
   *
   * @param brakePower The amount of power to send to the brakes.
   */
  void applyBrake(double brakePower);
  /**
   * applyThrottle method calls controlSignal to apply the amount
   * of throttle specified by the driver to speed up.
   * Returns void.
   *
   * @param throttlePower the amount of throttle to send to car.
   */
  void applyThrottle(double throttlePower);
}
