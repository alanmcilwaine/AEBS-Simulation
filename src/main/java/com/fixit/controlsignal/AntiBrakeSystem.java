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
   * @param curBrakePower The maximum amount of Brakes that the car should apply.
   * @param curWheelSpeed The current speed of the car's wheels.
   * @return The brake power that will be applied.
   */
  public double evaluate(double curBrakePower, double curWheelSpeed){
    double speedDif = curWheelSpeed - this.oldWheelSpeed;
    double amountToBrake = curBrakePower - oldBrakePower;

    setOldValues(curBrakePower, curWheelSpeed);

    if (curBrakePower <= 0.0 || speedDif > 0.5) { /* NB: 0.5 is a placeholder. */
      return 0.0; //The given brake power will not be applied.
    } else {
     return amountToBrake;
    }

  }

  /**
   * Keeps track of the current wheel speeds and brake power for later evaluation.
   *
   * @param newBrakePower The current level of power being applied to the brakes.
   * @param newWheelSpeed The current wheel-speeds of the car.
   */
  private void setOldValues(double newBrakePower, double newWheelSpeed){
    oldWheelSpeed = newWheelSpeed;
    oldBrakePower = newBrakePower;
  }
}