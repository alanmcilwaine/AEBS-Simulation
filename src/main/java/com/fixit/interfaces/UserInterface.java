package com.fixit.interfaces;

import static com.fixit.interfaces.Display.*;

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
   * receiveSpeed method gets called by sensor
   * package and then calls the Display class speedToShow to
   * display the speed to user.
   *
   * @param speed is the unit of measurement (kph) that
   *        will be displayed to the user.
   */

  public void receiveSpeed(final double speed) {
    speedToShow(speed);
    //calls speedToShow to add speed to the display
  }

  /**
   * receiveWarning method gets called by ControlSignal package
   * when there is a warning that needs to be displayed to the driver.
   * This can be anything such as ABS being triggered, AutoBrakeSystem
   * being triggered, or enabled/disabled.
   *
   * @param warning is the warning object that gets passed from
   *                ControlSignal that gets displayed to the user.
   */
  public void receiveWarning(final String warning) {
    System.out.println(warning);
    //placeholder logic to show user warning, not sure what data type yet.
  }

  /**
   * tick method is the method used to update
   * the Visual User Interface.
   */
  static void tick() {
    Display.display();
  }
}
