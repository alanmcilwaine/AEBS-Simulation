package fixit.car.sensors;

import java.util.List;
import org.junit.jupiter.api.Test;

import com.fixit.car.Car;
import com.fixit.car.sensors.SensorType;
import com.fixit.simulation.Weather;

public class SensorTest {
  @Test
  public void T04GoodInput() {
    List<List<Double>> goodInputs = List.of(
        List.of(10.0, 10.0, 10.0),
        List.of(20.0, 20.0, 20.0),
        List.of(100.0, 100.0, 100.0));

    Car c = Car.instance();
    for (List<Double> d : goodInputs) {
      c.sensorInput(SensorType.LIDARLEFT, d.get(0), Weather.SUNNY);
      c.sensorInput(SensorType.LIDARCENTRE, d.get(1), Weather.SUNNY);
      c.sensorInput(SensorType.LIDARRIGHT, d.get(2), Weather.SUNNY);
    }
  }

  @Test
  public void T04BadInput() {
    List<List<Double>> goodInputs = List.of(
        List.of(-10.0, 10.0, 10.0),
        List.of(-20.0, 20.0, 20.0),
        List.of(-100.0, 100.0, 100.0));

    Car c = Car.instance();

    try {
      for (List<Double> d : goodInputs) {
        c.sensorInput(SensorType.LIDARLEFT, d.get(0), Weather.SUNNY);
        c.sensorInput(SensorType.LIDARCENTRE, d.get(1), Weather.SUNNY);
        c.sensorInput(SensorType.LIDARRIGHT, d.get(2), Weather.SUNNY);
      }
      throw new Error("Error expected");
    } catch (AssertionError e) {
    }
  }
}
