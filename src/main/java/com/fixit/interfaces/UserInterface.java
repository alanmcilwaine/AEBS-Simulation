package com.fixit.interfaces;

/**
 * UI class holds functionality with the UI.
 * Contains methods to trigger brakes, and
 * disable the Automatic Braking system
 */
public class UserInterface implements Interface {
  /**
   * autoSystemToggle method calls controlSignal to
   * enable or disable the Automatic Emergency Braking system.
   * Returns void, but tells the user the state
   * of the system (on or off)
   */
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

  public void applyBrake(final double brakePower) {
    //call CS to apply brake
  }
  /**
   * applyThrottle method calls controlSignal to apply the amount
   * of throttle specified by the driver to speed up.
   * Returns void.
   *
   * @param throttlePower the amount of throttle to send to car.
   */

  public void applyThrottle(final double throttlePower) {
    //call CS to apply throttle
  }

  /**
   *
   * @param speed is the unit of measurement (kph) that will be displayed to the user.
   */
  @Override
  public void receiveSpeed(final double speed) {
    System.out.println(speed);    //placeholder logic to show user speed
  }

  /**
   *
   * @param warning is the warning object that gets passed from
   * ControlSignal that gets displayed to the user.
   */
  @Override
  public void receiveWarning(final String warning) {
    System.out.println(warning);  //placeholder logic to show user warning, not sure what data type yet.
  }
}
