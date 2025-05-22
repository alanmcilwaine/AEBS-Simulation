package com.fixit.aebs;

/**
 * The Automatic Emergency Braking System for vehicles. Would trigger a brake
 * signal to Control Signals if there are any hazards in front of the car
 */
public class AEBS implements AutoBrakeSystem {

  /**
   * the amount of brakes to send to control signal.
   */
  private double brakeValue = 0;

  /**
   * Returns the amount of brakes needed for the car.
   * Gives a 0 if no brake should be applied.
   *
   * @return returns the amount of brake value needed for the car
   */
  @Override
  public double getBrakeValue() {
    return brakeValue;
  }

  /**
   * Evaluates the system's automatic braking system.
   * Based on the distance between the vehicle and the road hazards.
   *
   * @param distanceData the distance of objects from the car
   * @param wheelSpeed the speed of the wheel.
   */
  @Override
  public void evaluateBraking(final double distanceData, final double wheelSpeed) {
    // TODO: Check for any more parameters needed to be added

    // Determines whether or braking should happen or not
    // This is to save resources on the calculations
    if (distanceData >= determineThreshold(wheelSpeed)) {
      brakeValue = 1;
    }
    brakeValue = 0;
  }

  /**
   * Determines the distance threshold for the brakes.
   * This threshold reflects the risk of the collision.
   * Calculates via:
   * Distance = Vehicle Speed * ReactionTime
   *
   * @param wheelSpeed the speed of the wheel
   * @return the distance at which the vehicle should send brake
   */
  private double determineThreshold(final double wheelSpeed) {
    // the average human reaction time is 0.25 seconds
    // for this purpose we will account for those who have
    // slower reaction times by increasing this value
    final double reactTime = 0.35;
    double threshold;

    threshold = wheelSpeed * reactTime;
    return threshold;
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
