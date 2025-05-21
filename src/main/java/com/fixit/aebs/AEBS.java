package com.fixit.aebs;

/**
 * The Automatic Emergency Braking System for vehicles. Would trigger a brake
 * signal to Control Signals if there are any hazards in front of the car
 */
public class AEBS implements AutoBrakeSystem {

  /**
   * Evaluates the system's automatic braking system.
   * Based on the distance between the vehicle and the road hazards.
   *
   * @param distanceData the distance of objects from the car
   * @param wheelSpeed the speed of the wheel.
   * @return returns the braking value.
   */
  @Override
  public double evaluateBraking(final double distanceData, final double wheelSpeed) {

    // Determines whether or braking should happen or not
    // This is to save resources on the calculations
    if (distanceData >= determineThreshold(wheelSpeed)) {
      return 1;
    }

    return 0;
  }

  /**
   * Determines the distance threshold for the brakes.
   * This threshold reflects the risk of the collision.
   *
   * @param wheelSpeed the speed of the wheel
   * @return the distance at which the vehicle should send brake
   */
  private double determineThreshold(final double wheelSpeed) {
    // TODO: find formula to how to calculate the threshold
    return 0;
  }

  /**
   * Determines how much the vehicle should brake.
   * Is calculated with the distance of other objects and vehicle wheel speed.
   *
   * @param distanceData the distance of the objects from the car.
   * @param wheelSpeed the speed of the wheel.
   * @return returns how much braking should be given
   */
  private double determineBrakes(final double distanceData, final double wheelSpeed) {
    double brakingPower = wheelSpeed - distanceData;
    return 0;
  }
}
