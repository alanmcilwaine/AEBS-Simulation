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

  /** Determines when we don't want the brake to be applied. */
  private boolean dontApplyBrake = false;

  /**
   * Calculates the amount of change in the wheel-speed over time.
   * This determines whether to apply the Anti-Brake system.
   *
   * @param applyBrakePower The amount of Brake Power that is to be applied.
   * @param newSpeed The new speed of the car's wheels. (In RPM.)
   * @return The brake power that will be applied.
   */
  public double evaluate(final double applyBrakePower, final double newSpeed) {
    /*
     * If in the previous tick, we chose to apply the ABS, we'll not apply the
     * brakes here, and keep record of this.
     */
    if (dontApplyBrake) {
      this.brakePower = 0.0;
      dontApplyBrake = false;
      return 0.0;
    }

    /*
     * We first take note of the brake power value entered, so we can give it
     * to the brakes.
     */
    this.brakePower = applyBrakePower;

    /*
     * We then calculate the difference in speed to find out if the speed is
     * massively changing, and therefore, find out if the wheels will slip.
     */
    double speedDif = newSpeed - oldWheelSpeed;

    //Keeps track of the current wheel speed for later evaluation.
    oldWheelSpeed = newSpeed;

    /*
     * If the difference in speed is more than the threshold, in the next
     * tick, we cannot apply any brakes.
     */
    if (applyBrakePower > 0.0 && !checkAgainstThreshold(speedDif)) {
      dontApplyBrake = true;
    }

    /*
     * Regardless of whether ABS kicked in or not, we'll return the amount of
     * brake power to apply.
     */
    return applyBrakePower;
  }

  /**
   * In order for the Brakes to apply, the car must be decreasing in speed,
   * and must not be decreasing by more than 75pm.
   * (NB: 75pm is currently a placeholder, and this value may change.)
   *
   * @param speedDif The calculated difference in wheel speed between ticks.
   * @return Whether the difference in speed meets the given requirements.
   */
  private boolean checkAgainstThreshold(final double speedDif) {
    final double speedDifThreshold = -75;
    return speedDif >= speedDifThreshold && speedDif < 0;
  }

  /**
   * Method that retrieves the set brake power and returns it.
   *
   * @return The brake power to apply to the brakes.
   */
  public double getBrakePowerToApply() {
    return this.brakePower;
  }
}
