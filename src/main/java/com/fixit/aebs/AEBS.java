package com.fixit.aebs;

public interface AEBS {

    /**
     * Evaluate the distance between the vehicle and other objects in the path and
     * determine whether they need braking.
     * @param distanceData the distance of objects from the car
     * @param wheelSpeed the speed of the wheel
     * @return returns how much brake to apply to the car
     */
     double evaluateBraking(double distanceData, double wheelSpeed);

    /**
     * Passes in the vehicle's wheel speed and that calculates the threshold on
     * when the brakes should hit
     * @param wheelSpeed the speed of the wheel
     * @return the braking threshold
     */
    double determineThreshold(double wheelSpeed);


}
