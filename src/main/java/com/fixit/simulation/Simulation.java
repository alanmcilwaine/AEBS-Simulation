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
  public static void main(String[] args) {
    ReadSimulationFile file = new ReadSimulationFile("src/main/java/com/fixit/simulation/testdata.txt");
    file.readData();
    Car car = Car.instance();

    try {

      for (List<Double> data : file.sensorData()) {
        car.sensorInput(SensorType.LIDARLEFT, data.get(0));
        car.sensorInput(SensorType.LIDARCENTRE, data.get(1));
        car.sensorInput(SensorType.LIDARRIGHT, data.get(2));

        Thread.sleep(50);
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}
