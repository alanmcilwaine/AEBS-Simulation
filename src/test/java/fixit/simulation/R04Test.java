package fixit.simulation;

import com.fixit.car.Car;
import com.fixit.car.sensors.SensorType;
import com.fixit.interfaces.Display;
import com.fixit.interfaces.UserInterface;
import com.fixit.simulation.Weather;
import org.junit.jupiter.api.Test;

import java.util.List;

public class R04Test {
  @Test
  public void T09() {
    Car car = Car.instance();
    List<List<Double>> testInputs = List.of(
            List.of(10.0, 10.0, 50.0),
            List.of(10.0, 10.0, 50.0),
            List.of(10.0, 10.0, 100.0)
    );
    for (List<Double> testInput : testInputs) {
      car.sensorInput(SensorType.LIDARLEFT, testInput.get(0), Weather.SUNNY);
      car.sensorInput(SensorType.LIDARCENTRE, testInput.get(1), Weather.SUNNY);
      car.sensorInput(SensorType.LIDARRIGHT, testInput.get(2), Weather.SUNNY);
    }
    assert Display.LIST_OF_ALERTS.contains("Lidar is incorrect 3 times. "
            + "Removing and adding new one.");
    UserInterface.removeWarning("Lidar is incorrect 3 times. "
            + "Removing and adding new one.");
  }
}
