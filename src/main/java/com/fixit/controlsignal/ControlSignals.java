package com.fixit.controlsignal;

import com.fixit.aebs.Aebs;
import com.fixit.car.Car;
import com.fixit.car.sensors.*;

/**
 * Signals that will be transmitted between the Automated Emergency Braking
 * System, the sensors of the car, and the car itself.
 */
public final class ControlSignals implements ControlSignal {
  /**
   * Creates an instance of the Control Signals Class. The constructor is
   * private to ensure only one instance of Control Signals is made.
   */
  private ControlSignals() {
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
    if (brakeValue != 0) {
      System.out.println("OBJECT DETECTED!! AEBS TRIGGERED.");
      System.out.println(brakeValue);
    } else {
      System.out.println("Car Speed: " + wSpeed + "km/h");
    }
    Car.instance().speed(wSpeed * (brakeValue != 0 ? brakeValue : 1));
  }

  public void processBrakePower(final double bPower) {
    assert bPower >= 0;
  }
}
