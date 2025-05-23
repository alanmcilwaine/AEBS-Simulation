package com.fixit.controlsignal;

/**
 * The Anti-Lock Brake system prevents the wheels from locking up during
 * braking. This will occur if there is a sudden change in the wheel-speed.
 * (Determined by the Wheel-speed's deceleration.)
 */
public class AntiBrakeSystem {
  /** The last recorded speed of the car's wheels. */
  private double oldWheelSpeed;

  /** The last recorded power level to apply to the brakes. */
  private double oldBrakePower;

  /**
   * Calculates the amount of change in the wheel-speed over time.
   * This determines whether to apply the Anti-Brake system.
   *
   * @param brakePower The amount of Brake Power that will be applied to the car.
   * @param newWheelSpeed The new speed of the car's wheels. (In RPM.)
   * @return The brake power that will be applied.
   */
  public double evaluate(double brakePower, double newWheelSpeed){
    /*
     * We first take note of the brake power value entered, so we can give it
     * to the brakes.
     */
    this.oldBrakePower = brakePower;

    /*
     * We then calculate the difference in speed to find out if the speed is
     * massively changing, and therefore, find out if the wheels will slip.
     */
    double speedDif = newWheelSpeed - oldWheelSpeed;

    //Keeps track of the current wheel speed for later evaluation.
    oldWheelSpeed = newWheelSpeed;

    /*
     * Applies the brake power, if the difference in speed is less than
     * the threshold, and if the car is applying the brakes.
     */
    if (brakePower > 0.0 && checkAgainstThreshold(speedDif))
      return brakePower;

    /*
     * The given brake power will therefore, need to be proportional to the
     * amount of tyre grip.
     */
    return speedDif;
  }

  /**
   * In order for the Brakes to apply, the car must be decreasing in speed,
   * and must not be decreasing by more than 75pm.
   * (NB: 75pm is currently a placeholder, and this value may change.)
   *
   * @return Whether the difference in speed is negative and above the given
   * negative threshold.
   */
  private boolean checkAgainstThreshold(double speedDif){
    final double SPEED_DIF_THRESHOLD = -75;
    return speedDif >= SPEED_DIF_THRESHOLD && speedDif < 0;
  }
}
