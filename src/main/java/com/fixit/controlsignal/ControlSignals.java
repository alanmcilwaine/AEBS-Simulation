package com.fixit.controlsignal;

import com.fixit.car.sensors.*;

/**
 * Signals that will be transmitted between the Automated Emergency Braking
 * System, the sensors of the car, and the car itself.
 */
public final class ControlSignals implements ControlSignal {
  /** The current speed of the car. */
  private double speed;

  /** The current power of the brakes being applied. */
  private double brakePower;

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
  public static ControlSignals cs() {
    return CONTROL_SIGNALS;
  }

  public void processSensorData(final SensorType sensorType, final double wheelSpeed) {
    assert sensorType != null;
    assert wheelSpeed >= 0;

    switch (sensorType){
      case SensorType.WHEELSPEEDLEFT:
      case SensorType.WHEELSPEEDRIGHT:

        //Car.instance().speed(data);

        break;
    }
  }

  public void processUserInput(final Action action, final double power) {
    assert action != null;
    assert power >= 0;
  }

  public void makeAnAction() {

  }
}
