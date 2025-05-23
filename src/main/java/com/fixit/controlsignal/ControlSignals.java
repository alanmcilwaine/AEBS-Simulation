package com.fixit.controlsignal;

import com.fixit.car.sensors.SensorType;

public final class ControlSignals implements ControlSignal {
  /** The current speed of the car. */
  double speed;

  /** The current power of the brakes being applied. */
  double brakePower;

  /**
   * Creates an instance of the Control Signals Class. As part of this,
   * the "Speed" and "Brake Power" variables are initialised. The constructor
   * is private to ensure only one instance of Control Signals is made.
   */
  private ControlSignals() {
    this.speed = 0.0;
    this.brakePower = 0.0;
  }

  /**
   * To ensure the rest of the code can use the Control Signals class, a
   * single instance of the class is created using the private constructor.
   */
  private static final ControlSignals CONTROL_SIGNALS = new ControlSignals();

  /**
   * The Singleton Control Signals instance can be accessed through this
   * method.
   *
   * @return The Control Signals instance created.
   */
  public static ControlSignals cs(){
    return CONTROL_SIGNALS;
  }

  public void processSensorData(final SensorType sensor, final double power) {
    /* INSERT CODE HERE */
  }

  public void processUserInput(final Action action, final double power) {
  }

  public void makeAnAction() {
  }
}
