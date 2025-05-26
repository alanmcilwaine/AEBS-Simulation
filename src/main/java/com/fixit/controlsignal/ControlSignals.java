package com.fixit.controlsignal;

import com.fixit.aebs.Aebs;
import com.fixit.car.Car;
import com.fixit.car.sensors.SensorType;

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
    assert CONTROL_SIGNALS != null;
    return CONTROL_SIGNALS;
  }

  /**
   * From JavaDoc comment in "Control Signal" Interface:
   * Processes data from the Wheel Speed Sensors; the data will be sent to the
   * car.
   *
   * @param sensorType The type of car sensor that we will be processing.
   *                   In this context, it will be the Wheel Speed Sensors.
   * @param wheelSpeed The current speed as detected by the sensors. This will
   *                   be in kilometers per hour. (km/h or kph.)
   */
  public void processSensorSpeed(
      final SensorType sensorType, final double wheelSpeed
  ) {
    assert sensorType != null;
    assert wheelSpeed >= 0;

    if (
        !(sensorType == SensorType.WHEELSPEEDLEFT
            || sensorType == SensorType.WHEELSPEEDRIGHT)
    ) {
      return;
    }
    double brakeValue = Aebs.instance().getBrakeValue();
    if (brakeValue != 0) {
      System.out.println("OBJECT DETECTED!! AEBS TRIGGERED.");
      System.out.println(brakeValue);
    } else {
      System.out.println("Car Speed: " + wheelSpeed + "km/h");
    }
    Car.instance().speed(wheelSpeed * (brakeValue != 0 ? brakeValue : 1));
  }

  /**
   * From JavaDoc comment in "Control Signal" Interface:
   * Processes the power of the brakes that will be applied. This involves
   * sending this value to the car.
   *
   * @param brakePower The brake power to apply to the car.
   */
  public void processBrakePower(final double brakePower) {
    assert brakePower >= 0;
  }
}
