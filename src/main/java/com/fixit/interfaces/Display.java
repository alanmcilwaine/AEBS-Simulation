package com.fixit.interfaces;

/**
 * Display Class will store all the interfaces required to show
 * the user the relevant data that it needs to see.
 */
public class Display {
  /**
   *
   */
  double speed = 0;
  /**
   *
   * @param v
   */

  public static void speedToShow(final double v) {
    speed = v;
  }

  /**
   * Display method is the method that will be used to
   * show to the user any information that pops up.
   */
  private void Display() {
    System.out.println("Speed is currently: " + speed + " kph");
  }
}
