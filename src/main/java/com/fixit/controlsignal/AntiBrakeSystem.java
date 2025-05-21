package com.fixit.controlsignal;

/**
 * The Anti-Lock Brake system prevents the wheels from locking up during
 * braking. This will occur if there is a sudden change in the wheel-speed.
 * (Determined by the Wheel-speed's deceleration.)
 */
public class AntiBrakeSystem {
  /** The last recorded speed of the car's wheels. */
  double oldWheelSpeed;

  /**
   * The last recorded power level on the car's brakes. This affects how much
   * the car will decelerate.
   */
  double oldBrakePower;

  /**
   * Calculates the amount of change in the wheel-speed over time.
   * This determines whether to apply the Anti-Brake system.
   *
   * @param brakePower The amount of Brake Power that will be applied to the car.
   * @param newWheelSpeed The new speed of the car's wheels. (In RPM.)
   * @return The brake power that will be applied.
   */
  public double evaluate(double brakePower, double newWheelSpeed){
    double speedDif = -(newWheelSpeed - oldWheelSpeed);

    //Keeps track of the current wheel speed for later evaluation.
    oldWheelSpeed = newWheelSpeed;

    if (brakePower <= 0.0 || speedDif > 75) { /* NB: 75 is a placeholder. */
      return 0.0; //The given brake power will not be applied.
    } else {
     return brakePower;
    }

  }
}