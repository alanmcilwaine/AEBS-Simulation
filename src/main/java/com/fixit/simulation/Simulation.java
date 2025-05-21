package com.fixit.simulation;

import com.fixit.car.Car;
import com.fixit.car.sensors.SensorType;

public class Simulation {
  public static void main(String[] args) {
    Car car = Car.instance();
    car.sensorInput(SensorType.LIDARCENTRE, 6.1);

    Car c = Car.instance();
  }
}
