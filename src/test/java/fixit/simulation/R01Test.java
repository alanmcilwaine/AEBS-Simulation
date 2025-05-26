package fixit.simulation;

import com.fixit.car.Car;
import com.fixit.car.sensors.SensorType;
import com.fixit.interfaces.Display;
import com.fixit.interfaces.UserInterface;
import com.fixit.simulation.Weather;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class R01Test {
  @Test
  public void T01() {
    Car car = Car.instance();
    List<List<Double>> badInputs = List.of(
            List.of(1.0, 50.0, 100.0),
            List.of(0.0, 30.0, 2000.0),
            List.of(20.0, 150.0, 300.0)
    );
    List<List<Double>> goodInputs = List.of(
            List.of(10.0, 10.0, 10.0)
    );
    for (List<Double> badInput : badInputs) {
      car.sensorInput(SensorType.LIDARLEFT, badInput.get(0), Weather.SUNNY);
      car.sensorInput(SensorType.LIDARCENTRE, badInput.get(1), Weather.SUNNY);
      car.sensorInput(SensorType.LIDARRIGHT, badInput.get(2), Weather.SUNNY);
      assert Display.LIST_OF_ALERTS.contains("2oo3 failed. Lidar do not agree.");
    }
    UserInterface.removeWarning("2oo3 failed. Lidar do not agree.");
    UserInterface.removeWarning("Lidar sensors have different data.");
    System.out.println(Display.LIST_OF_ALERTS);
    for (List<Double> goodInput : goodInputs) {
      car.sensorInput(SensorType.LIDARLEFT, goodInput.get(0), Weather.SUNNY);
      car.sensorInput(SensorType.LIDARCENTRE, goodInput.get(1), Weather.SUNNY);
      car.sensorInput(SensorType.LIDARRIGHT, goodInput.get(2), Weather.SUNNY);
      assert Display.LIST_OF_ALERTS.isEmpty();
    }
  }
  @Test
  public void T02() {

  }
  @Test
  public void T03() {

  }
}
