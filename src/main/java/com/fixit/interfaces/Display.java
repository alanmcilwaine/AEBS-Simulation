package com.fixit.interfaces;

import java.util.HashSet;
import java.util.Set;

/**
 * Display Class will store all the interfaces required to show
 * the user the relevant data that it needs to see.
 */
final class Display {
  /**
   *  speed variable is what will be used to display to driver.
   */
  private static double speed = 0;

  /**
   * listOfAlerts stores all the alerts that need to be displayed
   * to the driver.
   */
  private static final Set<String> LIST_OF_ALERTS = new HashSet<>();

  /**
   * speedToShow is the putter method that updates the speed
   * of the vehicle to then be displayed to the user.
   *
   * @param v is the passed variable that will update speed.
   */
  public static void speedToShow(final double v) {
    speed = v;
  }

  /**
   *  Takes in the errors to show to eventually show the user.
   *
   * @param error is the error that needs to be placed
   */
  public static void errorsToShow(final String error) {
    if (LIST_OF_ALERTS.contains(error)) {
      LIST_OF_ALERTS.remove(error);
    } else {
      LIST_OF_ALERTS.add(error);
    }
  }

  /**
   * display method is the method that will be used to
   * show to the user any information that pops up.
   */
  public static void display() {
    assert speed >= 0;
    System.out.println("Speed is currently: " + speed + " kph");
    if (!LIST_OF_ALERTS.isEmpty()) {
      System.out.println("Alerts: " + LIST_OF_ALERTS);
    }
  }

  private Display() {
  }
}
