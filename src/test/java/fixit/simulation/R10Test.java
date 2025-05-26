package fixit.simulation;

import com.fixit.car.Car;
import com.fixit.car.sensors.SensorType;
import com.fixit.interfaces.Display;
import com.fixit.interfaces.UserInterface;
import com.fixit.simulation.Weather;
import org.junit.jupiter.api.Test;

import java.util.List;

public class R10Test {
  @Test
  public void T15() {
    Car car = Car.instance();
    List<List<Double>> lowSeverity = List.of(
            List.of(20.0, 10.0, 10.0),
            List.of(20.0, 10.0, 10.0),
            List.of(20.0, 10.0, 10.0)
    );
    List<List<Double>> medSeverity = List.of(
            List.of(10.0, 10.0, 10.0),
            List.of(10.0, 10.0, 10.0),
            List.of(10.0, 10.0, 10.0),
            List.of(10.0, 10.0, 10.0),
            List.of(10.0, 10.0, 10.0),
            List.of(10.0, 10.0, 10.0),
            List.of(10.0, 10.0, 10.0)
    );

    List<List<Double>> highSeverity = List.of(
            List.of(2.0, 2.0, 2.0),
            List.of(2.0, 2.0, 2.0),
            List.of(2.0, 2.0, 2.0),
            List.of(2.0, 2.0, 2.0),
            List.of(2.0, 2.0, 2.0),
            List.of(2.0, 2.0, 2.0),
            List.of(2.0, 2.0, 2.0),
            List.of(2.0, 2.0, 2.0)
    );
    // Low severity case. This is when a sensor might fail.
    for (List<Double> input : lowSeverity) {
      car.sensorInput(SensorType.LIDARLEFT, input.get(0), Weather.SUNNY);
      car.sensorInput(SensorType.LIDARRIGHT, input.get(2), Weather.SUNNY);
      car.sensorInput(SensorType.LIDARCENTRE, input.get(1), Weather.SUNNY);
    }
    assert Display.LIST_OF_ALERTS.contains("Lidar is incorrect 3 times. "
            + "Removing and adding new one.");

    // Medium severity. This is when an object appears. But further away.
    car.speed(100);
    for (List<Double> input : medSeverity) {
      car.sensorInput(SensorType.WHEELSPEEDLEFT, car.speed(), Weather.SUNNY);
      car.sensorInput(SensorType.WHEELSPEEDRIGHT, car.speed(), Weather.SUNNY);
      car.sensorInput(SensorType.LIDARLEFT, input.get(0), Weather.SUNNY);
      car.sensorInput(SensorType.LIDARRIGHT, input.get(2), Weather.SUNNY);
      car.sensorInput(SensorType.LIDARCENTRE, input.get(1), Weather.SUNNY);
    }
    assert car.speed() < 10;

    // High severity. This is when the object is directly in front of the car.
    car.speed(100);
    for (List<Double> input : highSeverity) {
      car.sensorInput(SensorType.WHEELSPEEDLEFT, car.speed(), Weather.SUNNY);
      car.sensorInput(SensorType.WHEELSPEEDRIGHT, car.speed(), Weather.SUNNY);
      car.sensorInput(SensorType.LIDARLEFT, input.get(0), Weather.SUNNY);
      car.sensorInput(SensorType.LIDARRIGHT, input.get(2), Weather.SUNNY);
      car.sensorInput(SensorType.LIDARCENTRE, input.get(1), Weather.SUNNY);
    }
    // A very low number is registered as 0. Traditionally, the car will
    // move forward by itself even in brake.
    assert car.speed() < 2;
  }
}
