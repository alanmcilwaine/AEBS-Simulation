package com.fixit.controlsignal;

public class ControlSignals implements ControlSignal {
  /** The current speed of the car. */
  double speed = 0.0;

  /** The current power of the brakes being applied. */
  double brakePower = 0.0;

  public void processSensorData(SensorType sensor, double power) {
    /* INSERT CODE HERE */
  }

  public void processUserInput(Action action, double power) {
  }

  public void makeAnAction() {

  }
}

/** "Mock Objects" to make the code compile. */
record SensorType() {}
