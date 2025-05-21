package com.fixit.interfaces;

/**
 * UI class holds functionality with the UI.
 * Contains methods to trigger brakes, and disable the
 * Automatic Braking system
 */
public class UI implements Interface {
  @Override
  public void autoSystemToggle() {
    //call CS to toggle Automatic Emergency Brake System
  }
  /**
   * applyBrake method calls controlSignal to apply the amount
   * of brakes specified by the driver.
   * Returns void
   *
   * @param brakePower The amount of power to send to the brakes.
   */
  @Override
  public void applyBrake(double brakePower){
    //call CS to apply brakes
  }

  @Override
  public void applyThrottle(double throttlePower) {

  }
}
