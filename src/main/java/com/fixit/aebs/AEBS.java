package com.fixit.aebs;

/**
 * The Automatic Emergency Braking System for vehicles. Would trigger a brake
 * signal to Control Signals if there are any hazards in front of the car.
 **/
final class AEBS implements AutoBrakeSystem {

  /* the amount of brakes to send to control signal. */
  private static double brakeValue = 0;

  /* checks if the system has received distance and speed values from sensor */
  private static boolean distanceReceived = false;
  private static boolean speedReceived = false;

  /* the distance and speed values themselves that were received */
  private static double distance = 0;
  private static double speed = 0;

  /* the singular instance of AEBS that the car is using */
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
  public AEBS aebs() {
    return instance;
  }

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
  public void evaluateBraking(final double distanceData, final double wheelSpeed) {
    // TODO: Check for any more parameters needed to be added

    // Determines whether or braking should happen or not
    // This is to save resources on the calculations
    if (distanceData >= determineThreshold(wheelSpeed)) {
      brakeValue = determineBrakes(distanceData, wheelSpeed);
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
   * @param wheelSpeed the speed of the wheel
   * @return the distance at which the vehicle should send brake
   */
  private double determineThreshold(final double wheelSpeed) {
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
   * @param distanceData the distance of the objects from the car in km.
   * @param wheelSpeed the speed of the wheel in km/h.
   * @return returns how much braking should be given
   */
  private static double determineBrakes(final double distanceData, final double wheelSpeed) {
    double brakingPower = wheelSpeed - distanceData;
    return 0;
  }

  /**
   * Sends AEBS distance data of other obejcts on the road.
   * This should only be used by the Sensors.
   *
   * @param distanceData the distance of the other objects from the vehicle.
   */
  public static void receiveDistanceAEBS(final double distanceData) {
    distance = distanceData;
    distanceReceived = true;
    instance.tick();
  }

  /**
   * Sends AEBS speed data of the vehicle.
   * This should only be used by the Sensors.
   *
   * @param wheelSpeed the speed of the vehicle itself
   */
  public static void receiveSpeedAEBS(final double wheelSpeed) {
    speed = wheelSpeed;
    distanceReceived = true;
    instance.tick();
  }

  private void tick() {

    // if the distance and speed has been received
    if (distanceReceived && speedReceived) {

      distanceReceived = false;
      speedReceived = false;
    }

  }
}
