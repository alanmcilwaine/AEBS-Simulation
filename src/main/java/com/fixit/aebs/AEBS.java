package com.fixit.aebs;

/**
 * The Automatic Emergency Braking System for vehicles. Would trigger a brake
 * signal to Control Signals if there are any hazards in front of the car.
 **/
final class AEBS implements AutoBrakeSystem {

  /** the amount of brakes to send to control signal. */
  private static double brakeValue = 0;

  /** checks if the system has received distance and speed values from sensor. */
  private static boolean distanceReceived = false;
  private static boolean speedReceived = false;

  /** the distance and speed values themselves that were received. */
  private static double distanceData = 0;
  private static double wheelSpeed = 0;

  /** the singular instance of AEBS that the car is using. */
  private static final AEBS instance = new AEBS();

  /**
   * Private constructor for the AEBS.
   * It is private in order to ensure the singleton pattern.
   */
  private AEBS() {

  }

  /**
   * Returns the only instance of AEBS to be used.
   * There should only be one instance. Control Signal should
   * call this method in order to access the braking values.
   *
   * @return the single instance of AEBS to be used.
   */
  @Override
  public AEBS instance() {
    return instance;
  }

  /**
   * Returns the amount of brakes needed for the car.
   * Gives a 0 if no brake should be applied.
   s*
   * @return returns the amount of brake value needed for the car
   */
  public double getBrakeValue() {
    return brakeValue;
  }

  /**
   * Evaluates the system's automatic braking system.
   * Based on the distance between the vehicle and the road hazards.
   */
  private void evaluateBraking() {

    // Determines whether or braking should happen or not
    // This is to save resources on the calculations
    if (distanceData >= determineThreshold()) {
      brakeValue = determineBrakes();
    } else {
      brakeValue = 0;
    }


  }

  /**
   * Determines the distance threshold for the brakes.
   * This threshold reflects the risk of the collision.
   * Calculates via:
   * Distance = Vehicle Speed * ReactionTime
   *
   * @return the distance at which the vehicle should send brake
   */
  private double determineThreshold() {
    // the average human reaction time is 0.25 seconds
    // for this purpose we will account for those who have
    // slower reaction times by increasing this value
    final double reactTime = 0.35;

    return wheelSpeed * reactTime;
  }

  /**
   * Determines how much the vehicle should brake.
   * Is calculated with the distance of other objects and vehicle wheel speed.
   *
   * @return returns how much braking should be given
   */
  private static double determineBrakes() {
    double brakingPower = wheelSpeed - distanceData;
    return 0;
  }

  /**
   * Sends AEBS distance data of other obejcts on the road.
   * This should only be used by the Sensors.
   *
   * @param distanceDataReceived the distance of the other objects from the vehicle.
   */
  public static void receiveDistanceAEBS(final double distanceDataReceived) {
    distanceData = distanceDataReceived;
    distanceReceived = true;
    instance.tick();
  }

  /**
   * Sends AEBS speed data of the vehicle.
   * This should only be used by the Sensors.
   *
   * @param wheelSpeedReceived the speed of the vehicle itself
   */
  public static void receiveSpeedAEBS(final double wheelSpeedReceived) {
    wheelSpeed = wheelSpeedReceived;
    speedReceived = true;
    instance.tick();
  }

  /**
   * This ticks the AEBS to process the information that has been received.
   * This is called by the methods receiveSpeedAEBS and
   * receiveDistanceAEBS. Should only do something when
   * both data has been gathered.
   */
  private void tick() {

    // if the distance and speed has been received
    if (distanceReceived && speedReceived) {

      evaluateBraking();
      distanceReceived = false;
      speedReceived = false;
    }

  }
}
