package com.fixit.aebs;

/**
 * The interface for the automatic braking system in the car.
 * Uses the distance from the car to other objects on the road
 * from the sensors. Control Signals uses getBrakeValue() to
 * find the amount of brakes needed.s
 */
public interface AutoBrakeSystem {

  /**
   * Evaluate the distance between the vehicle and other objects in the path.
   * Determines whether car needs braking.
   *
   * @param distanceData the distance of objects from the car
   * @param wheelSpeed the speed of the wheel
   */
  void evaluateBraking(double distanceData, double wheelSpeed);

  /**
   * Returns the amount of brakes needed for the car.
   * Gives a 0 if no brake should be applied.
   *
   * @return returns the amount of brake value needed for the car
   */
  double getBrakeValue();
}
