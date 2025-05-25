package com.fixit.interfaces;

import java.util.ArrayList;

/**
 * Display Class will store all the interfaces required to show
 * the user the relevant data that it needs to see.
 */
class Display {
  /**
   *  speed variable is what will be used to display to driver.
   */
  private static double speed = 0;

  /**
   * UPPERBOUND will be used to limit the number of Alerts that
   * can be stored.
   */
  public static final int UPPERBOUND = 99;
  /**
   * listOfAlerts stores all the alerts that need to be displayed
   * to the driver.
   */
  private static ArrayList<String> listOfAlerts = new ArrayList<String>();

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
   * @param error does thingy
   */
  public static void errorsToShow(final String error) {
    //TODO: will add to list of errors to show to eventually display
    int numAlerts = 0;
    for (String alert : listOfAlerts) {
      int maxAlerts = 99;
      if (numAlerts >= maxAlerts) {
        break;
      }
      numAlerts++;
    }
  }

  /**
   * display method is the method that will be used to
   * show to the user any information that pops up.
   */
  public static void display() {
    System.out.println("Speed is currently: " + speed + " kph");
  }
}
