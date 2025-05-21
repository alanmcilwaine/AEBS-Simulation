package com.fixit.aebs;

/**
 * The Automatic Emergency Braking System for vehicles. Would trigger a brake
 * signal to Control Signals if there are any hazards in front of the car
 */
public class AEBS implements AutoBrakeSystem {


  /**
   * Evaluates how much the system should brake.
   * Based on the distance between the vehicle and the road hazards.
   *
   * @param distanceData th e distance of objects from the car
   * @param wheelSpeed the speed of the wheel.
   * @return returns the amount of brakes to use.
   */
  @Override
  public double evaluateBraking(final double distanceData, final double wheelSpeed) {
    // TODO: call determineThreshold and calculate how much brakes to put in
    return 0;
  }

  /**
   * Determines the threshold on when the brakes should be activated.
   *
   * @param wheelSpeed the speed of the wheel
   * @return the braking threshold
   */
  private double determineThreshold(final double wheelSpeed) {
    // TODO: find formula to how to calculate the threshold
    return 0;
  }
}
