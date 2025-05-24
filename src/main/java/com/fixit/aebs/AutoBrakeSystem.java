package com.fixit.aebs;

/**
 * The interface for the automatic braking system in the car.
 * Uses the distance from the car to other objects on the road
 * from the sensors. The AutoBrakeSystems in a car should only
 * have one of each instance, which can be taken by calling
 * instance().
 */
public interface AutoBrakeSystem {

  /**
   * Returns the instance of the braking system.
   * This is to ensure that the singleton pattern is upheld.
   *
   * @return returns the instance of the braking system.
   */
  AutoBrakeSystem instance();
}
