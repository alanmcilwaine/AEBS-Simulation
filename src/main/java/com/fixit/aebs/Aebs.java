package com.fixit.aebs;

/**
 * The Automatic Emergency Braking System for vehicles. Would trigger a brake
 * signal to Control Signals if there are any hazards in front of the car.
 **/
public final class Aebs {

  /** the amount of brakes to send to control signal. */
  private static double brakeValue = 0;

  /** checks if the system has received distance values from sensor. */
  private static boolean distanceReceived = false;

  /** checks if the system has received speed values from sensor. */
  private static boolean speedReceived = false;

  /** the distance that was received, measured in m. */
  private static double distanceData = 0;

  /** the distance that was received, measured in m/s. */
  private static double wheelSpeed = 0;

  /** the singular instance of AEBS that the car is using. */
  private static final Aebs INSTANCE = new Aebs();

  /**
   * Private constructor for the AEBS.
   * It is private in order to ensure the singleton pattern.
   */
  private Aebs() {
    assert brakeValue == 0;
    assert !distanceReceived;
    assert !speedReceived;
  }

  /**
   * Returns the only instance of AEBS to be used.
   * There should only be one instance. Control Signal should
   * call this method in order to access the braking values.
   *
   * @return the single instance of AEBS to be used.
   */
  public static Aebs instance() {
    return INSTANCE;
  }

  /**
   * Returns the amount of brakes needed for the car.
   * Gives a 0 if no brake should be applied.
   *
   * @return returns the amount of brake value needed for the car.
   */
  public double getBrakeValue() {
    assert brakeValue >= 0;
    double brakeReturn = brakeValue;
    // reset the value back to zero once it has been sent.
    brakeValue = 0;
    return brakeReturn;
  }

  /**
   * Evaluates the system's automatic braking system.
   * Based on the distance between the vehicle and the road hazards.
   */
  private void evaluateBraking() {
    assert distanceData >= 0;
    assert wheelSpeed >= 0;

    final double reactTime = 0.35;
    final double brakeThreshold = wheelSpeed * reactTime;
    final double brakeMargin = 1.10;
    final double percentageWrap = 100;

    // Determines whether or braking should happen.
    if (distanceData < brakeThreshold) {
      // taken from vf^2 = vi^2 + 2ad. find deceleration and add error margin.
      double deceleration = (wheelSpeed * wheelSpeed) / (2 * distanceData);
      deceleration *= brakeMargin;

      // assert brake value non-negative and turn it into percentage.
      assert brakeValue >= 0;
      brakeValue = (deceleration / wheelSpeed) * percentageWrap;
      return;
    }
    // if there is no need to brake then it's just 0
    brakeValue = 0;
  }

  /**
   * Sends AEBS distance data of other objects on the road.
   * This should only be used by the Sensors. Calls tick().
   *
   * @param distanceDataReceived the distance of other objects from vehicle.
   */
  public void receiveDistanceAebs(final double distanceDataReceived) {
    assert distanceDataReceived >= 0;
    final double kmToM = 1000;
    distanceData = distanceDataReceived * kmToM;
    distanceReceived = true;
    INSTANCE.tick();
  }

  /**
   * Sends AEBS speed data of the vehicle.
   * This should only be used by the Sensors. Calls tick().
   *
   * @param wheelSpeedReceived the speed of the vehicle itself
   */
  public void receiveSpeedAebs(final double wheelSpeedReceived) {
    assert wheelSpeedReceived >= 0;
    final double kmhToMs = 3.6;
    wheelSpeed = wheelSpeedReceived / kmhToMs;
    speedReceived = true;
    INSTANCE.tick();
  }

  /**
   * This ticks the AEBS to process the information that has been received.
   * Should only do something when both data has been gathered.
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
