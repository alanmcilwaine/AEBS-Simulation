package com.fixit.controlsignal;

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

  public void processSensorSpeed(final SensorType sType, final double wSpeed) {
    assert sType != null;
    assert wSpeed >= 0;

    /*
     * Here, we will be sending the retrieved Wheel Speed to the car in order
     * for the speed to be adjusted. This will only happen in the case of the
     * sensors detecting the Wheel Speed.
     */
    switch (sType){
      case SensorType.WHEELSPEEDLEFT:
      case SensorType.WHEELSPEEDRIGHT:

        Car.instance().speed(wSpeed);

        break;
    }
  }

  public void processBrakePower(final Action action, final double bPower) {
    assert action != null;
    assert bPower >= 0;
  }
}
