package com.fixit.interfaces;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.fixit.interfaces.Display.errorsToShow;
import static com.fixit.interfaces.Display.speedToShow;

/**
 * UI class holds functionality with the UI.
 * Contains methods to trigger brakes, and
 * disable the Automatic Braking system
 */
public class UserInterface implements Interface, KeyListener {
  /**
   * autoSystemToggle method calls controlSignal to
   * enable or disable the Automatic Emergency Braking system.
   * Returns void, but tells the user the state
   * of the system (on or off)
   */
  public void autoSystemToggle() {
    //TODO: call CS to toggle Automatic Emergency Brake System
  }
  /**
   * applyBrake method calls controlSignal to apply the amount
   * of brakes specified by the driver.
   * Returns void
   *
   * @param brakePower The amount of power to send to the brakes.
   */

  public void applyBrake(final double brakePower) {
    //TODO: call CS to apply brake
  }
  /**
   * applyThrottle method calls controlSignal to apply the amount
   * of throttle specified by the driver to speed up.
   * Returns void.
   *
   * @param throttlePower the amount of throttle to send to car.
   */

  public void applyThrottle(final double throttlePower) {
    //TODO: call CS to apply throttle
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
    errorsToShow(warning);
  }

  /**
   * tick method is the method used to update
   * the Visual User Interface.
   */
  static void tick() {
    Display.display();
  }

  /**
   * Invoked when a key has been typed. See the class description
   * for {@link KeyEvent} for a definition of a key typed event.
   *
   * @param e the event to be processed
   */
  @Override
  public void keyTyped(KeyEvent e) {

  }

  /**
   * Invoked when a key has been pressed. See the class description
   * for {@link KeyEvent} for a definition of a key pressed event.
   *
   * @param e the event to be processed
   */
  @Override
  public void keyPressed(KeyEvent e) {

  }

  /**
   * Invoked when a key has been released. See the class description
   * for {@link KeyEvent} for a definition of a key released event.
   *
   * @param e the event to be processed
   */
  @Override
  public void keyReleased(KeyEvent e) {

  }
}
