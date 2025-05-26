package com.fixit.simulation;

import com.fixit.car.Car;
import com.fixit.car.sensors.SensorType;
import java.util.List;

/**
 * Simulates the sensors of a car by send it data read from a file.
 *
 * @author Ming Bao.
 */
public class Simulation {
  /**
   * The time in between each piece of data sent to car.
   */
  static final int SLEEPTIME = 50;

  /**
   * Runs the simulation.
   */
  @SuppressWarnings("checkstyle:MagicNumber")
  private void run() {
    ReadSimulationFile file = new ReadSimulationFile(
        "simulationData/brake.txt");
    file.readData();
    Car car = Car.instance();
    car.speed(file.initSpeed());
    double rpmSpeed = (car.speed() * 25.0) / (3.0 * Math.PI * 0.25);

    try {
      for (List<Double> data : file.sensorData()) {
        car.sensorInput(SensorType.LIDARLEFT, data.get(0), file.weather());
        car.sensorInput(SensorType.LIDARCENTRE, data.get(1), file.weather());
        car.sensorInput(SensorType.LIDARRIGHT, data.get(2), file.weather());
        car.sensorInput(SensorType.WHEELSPEEDLEFT, rpmSpeed, file.weather());
        car.sensorInput(SensorType.WHEELSPEEDRIGHT, rpmSpeed, file.weather());
        Thread.sleep(SLEEPTIME);
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
    System.out.println("Simulation Ended");
  }

  /**
   * Main function for a simulation.
   *
   * @param ignoredArgs Is not used.
   */
  public static void main(final String[] ignoredArgs) {
    Simulation simulation = new Simulation();
    simulation.run();
  }
}
