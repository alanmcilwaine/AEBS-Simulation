package com.fixit.aebs;

/**
 * Represents the distance sensitivity of the AEBS of the car.
 * Has 5 settings: MAX, HIGH, MEDIUM, LOW, NONE.
 */
public enum Sensitivity {
  /** The highest possible distance sensitivity for AEBS (0.75). */
  HIGH {
    @SuppressWarnings("checkstyle:MagicNumber")
    @Override
    public double sensitivity() {
      return 0.75;
    }
  },
  /** The neutral distance sensitivity for AEBS (0.5). */
  MEDIUM {
    @SuppressWarnings("checkstyle:MagicNumber")
    @Override
    public double sensitivity() {
      return 0.5;
    }
  },
  /** The lowest possible distance sensitivity for AEBS (0.25). */
  LOW {
    @SuppressWarnings("checkstyle:MagicNumber")
    @Override
    public double sensitivity() {
      return 0.25;
    }
  },
  /** Setting for disabled AEBS. */
  NONE;

  /**
   * Getter for the sensitivity value for AEBs to use.
   *
   * @return the sensitivity value.
   */
  public double sensitivity() {
    return 0;
  }
}
