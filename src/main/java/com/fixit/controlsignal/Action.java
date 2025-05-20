package com.fixit.controlsignal;

/**
 * Defines the Action that the Automated Emergency Braking System (ABES) will
 * take.
 */
public enum Action {
  /** The car will maintain the status quo. (i.e. Remain in idle.) */
  NONE,
  /** The car will apply the brakes; may be ordered by the ABES. */
  BRAKE,
  /** The car will apply the accelerator. */
  ACCELERATE
}
