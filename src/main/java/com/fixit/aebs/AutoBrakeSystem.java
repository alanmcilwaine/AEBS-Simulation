package com.fixit.aebs;

public interface AutoBrakeSystem {

    /**
     * Evaluate the distance between the vehicle and other objects in the path and
     * determine whether they need braking.
     *
     * @param distanceData the distance of objects from the car
     * @param wheelSpeed the speed of the wheel
     * @return returns how much brake to apply to the car
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
