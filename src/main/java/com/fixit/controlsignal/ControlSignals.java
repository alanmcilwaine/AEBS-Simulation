package com.fixit.controlsignal;

import com.fixit.aebs.Aebs;
import com.fixit.car.Car;
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
    this.speed = Car.instance().speed();
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

  public void processSensorSpeed(final SensorType sType, final double wSpeed) {
    assert sType != null;
    assert wSpeed >= 0;

    if (!(sType == SensorType.WHEELSPEEDLEFT || sType == SensorType.WHEELSPEEDRIGHT)) {
      return;
    }

    double brakeValue = Aebs.instance().getBrakeValue();
    Car.instance().speed(wSpeed * (brakeValue != 0 ? brakeValue : 1));
  }

  public void processBrakePower(final double bPower) {
    assert bPower >= 0;
  }
}
