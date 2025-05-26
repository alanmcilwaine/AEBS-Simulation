package com.fixit.interfaces;

import com.fixit.aebs.Aebs;
import com.fixit.aebs.Sensitivity;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.fixit.interfaces.Display.*;


/**
 * UI class holds functionality with the UI.
 * Contains methods to trigger brakes, and
 * disable the Automatic Braking system
 */
public class UserInterface implements Interface, KeyListener {
  /**
   * throttlePower is the variable that keeps the value of how
   * much throttle to apply.
   */
  private static double throttle = 0;

  /**
   * brakePower is the variable that keeps the value of how
   * much throttle to apply.
   */
  private static double brake = 0;

  /**
   * INCREMENT is the value stored for applying more
   * or less brakes or throttle.
   */
  private static final double INCREMENT = 0.1;

  /**
   * applyBrake method calls controlSignal to apply the amount of
   * throttle specified by the driver to speed up.
   * Returns void.
   *
   * @param brakePower the amount of brake to send to car.
   */
  public static void applyBrake(final double brakePower) {
    //TODO: call CS to apply brake
  }

  /**
   * applyThrottle method calls controlSignal to apply the amount of
   * throttle specified by the driver to speed up.
   * Returns void.
   *
   * @param throttlePower the amount of throttle to send to car.
   */
  public void applyThrottle(final double throttlePower) {
    //TODO: call CS to apply throttle
  }

  /**
   * receiveSpeed method gets called by sensor package and then calls
   * the Display class speedToShow to display the speed
   * to user.
   *
   * @param speed is the unit of measurement (kph) that will be
   *             displayed to the user.
   */
  public static void receiveSpeed(final double speed) {
    speedToShow(speed);
  }

  /**
   * receiveWarning method gets called by ControlSignal package when there
   * is a warning that needs to be displayed to the driver. This can be anything
   * such as ABS being triggered, AutoBrakeSystem being triggered,
   * or enabled/disabled.
   *
   * @param warning is the warning object that gets passed from
   *               ControlSignal that gets displayed to the user.
   */
  public static void receiveWarning(final String warning) {
    System.out.println("Interface (WARNING): " + warning);
    errorsToShow(warning);
  }

  /**
   * removeWarning is a method called by ControlSignal when there is a
   * warning to be removed.
   *
   * @param warning The exact warning string that needs to be removed.
   */
  public static void removeWarning(final String warning) {
    errorsToRemove(warning);
  }

  /**
   * tick method is the method used to update the Visual User Interface.
   */
  static void tick() {
    display();
  }

  /**
   * Invoked when a key has been typed. See the class description for
   * {@link KeyEvent} for a definition of a key typed event.
   *
   * @param e the event to be processed
   */
  @Override
  public void keyTyped(final KeyEvent e) {

  }

  /**
   * Invoked when a key has been pressed. See the class description for
   * {@link KeyEvent} for a definition of a key pressed event.
   *
   * @param e the event to be processed
   */
  @Override
  public void keyPressed(final KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_0) {
      Aebs.instance().setSensitivity(Sensitivity.NONE);
      receiveWarning(" AEBS Disabled ");
    }
    if (e.getKeyCode() == KeyEvent.VK_1) {
      Aebs.instance().setSensitivity(Sensitivity.LOW);
      receiveWarning(" AEBS set to Low ");
    }
    if (e.getKeyCode() == KeyEvent.VK_2) {
      Aebs.instance().setSensitivity(Sensitivity.MEDIUM);
      receiveWarning(" AEBS set to Medium ");
    }
    if (e.getKeyCode() == KeyEvent.VK_3) {
      Aebs.instance().setSensitivity(Sensitivity.HIGH);
      receiveWarning(" AEBS set to High ");
    }
    if (e.getKeyCode() == KeyEvent.VK_UP) {
      assert throttle <= 1;
      assert throttle >= 0;
      throttle += INCREMENT;
      applyThrottle(throttle);
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
      assert throttle <= 1;
      assert throttle >= 0;
      throttle -= INCREMENT;
      applyThrottle(throttle);
    }
    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      assert brake <= 1;
      assert brake >= 0;
      brake += INCREMENT;
      applyBrake(brake);
    }
    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      assert brake <= 1;
      assert brake >= 0;
      brake -= INCREMENT;
      applyBrake(brake);
    }
  }

  /**
   * Invoked when a key has been released. See the class description for
   * {@link KeyEvent} for a definition of a key released event.
   *
   * @param e the event to be processed
   */
  @Override
  public void keyReleased(final KeyEvent e) {

  }
}
