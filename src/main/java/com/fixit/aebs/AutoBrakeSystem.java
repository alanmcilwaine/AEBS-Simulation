package com.fixit.aebs;

public interface AutoBrakeSystem {

    /**
     * Evaluate the distance between the vehicle and other objects in the path and
     * determine whether they need braking.
     * @param distanceData the distance of objects from the car
     * @param wheelSpeed the speed of the wheel
     * @return returns how much brake to apply to the car
     */
     double evaluateBraking(double distanceData, double wheelSpeed);


}
