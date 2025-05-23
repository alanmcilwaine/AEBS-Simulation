package com.fixit.controlsignal;

/**
 * The Anti-Lock Brake system prevents the wheels from locking up during
 * braking. This will occur if there is a sudden change in the wheel-speed.
 * (Determined by the Wheel-speed's deceleration.)
 */
public class AntiBrakeSystem {
  /** The last recorded speed of the car's wheels. */
  private double oldWheelSpeed;

  /** The recorded power level to apply to the brakes. */
  private double brakePower;

  /**
   * Threshold that determines if there's going to be a massive change in
   * speed, and therefore, if the brakes are likely to lock.
   */
  final double SPEED_DIF_THRESHOLD = -75;

  //
  private boolean dont_apply_brake = false;

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
     * If in the previous tick, we chose to apply the ABS, we'll not apply the
     * brakes here, and keep record of this.
     */
    if (dont_apply_brake){
      this.brakePower = 0.0;
      dont_apply_brake = false;
      return 0.0;
    }

    /*
     * We first take note of the brake power value entered, so we can give it
     * to the brakes.
     */
    this.brakePower = brakePower;

    /*
     * We then calculate the difference in speed to find out if the speed is
     * massively changing, and therefore, find out if the wheels will slip.
     */
    double speedDif = newWheelSpeed - oldWheelSpeed;

    //Keeps track of the current wheel speed for later evaluation.
    oldWheelSpeed = newWheelSpeed;

    /*
     * If the difference in speed is more than the threshold, in the next
     * tick, we cannot apply any brakes.
     */
    if (brakePower > 0.0 && !checkAgainstThreshold(speedDif))
      dont_apply_brake = true;

    /*
     * Regardless of whether ABS kicked in or not, we'll return the amount of
     * brake power to apply.
     */
    return brakePower;
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
    return speedDif >= SPEED_DIF_THRESHOLD && speedDif < 0;
  }
}
