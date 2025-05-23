package com.fixit.interfaces;

/**
 * Display Class will store all the interfaces required to show
 * the user the relevant data that it needs to see.
 */
public class Display {
  /**
   *  speed variable is what will be used to display to driver.
   */
  private static double speed = 0;

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
   *  Takes in the errors to show to eventually show the user
   *
   * @param error does thingy
   */
  public static void errorsToShow(final String error) {

  }

  /**
   * display method is the method that will be used to
   * show to the user any information that pops up.
   */
  public static void display() {
    System.out.println("Speed is currently: " + speed + " kph");
  }
}
