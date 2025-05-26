package fixit.simulation;

import com.fixit.car.Car;
import com.fixit.car.sensors.SensorType;
import com.fixit.interfaces.Display;
import com.fixit.simulation.Weather;
import org.junit.jupiter.api.Test;

import java.util.List;

public class R05Test {
  @Test
  public void T10() {
    Car car = Car.instance();
    List<List<Double>> badInputs = List.of(
        List.of(1.0, 50.0, 100.0),
        List.of(0.0, 30.0, 2000.0),
        List.of(20.0, 150.0, 300.0),
        List.of(5.0, 0.0, 21.0),
        List.of(666.0, 999.0, 222.0),
        List.of(123.0, 456.0, 789.0),
        List.of(2.0, 0.0, 1.0),
        List.of(241.0, 371.0, 271.0),
        List.of(101.0, 201.0, 301.0),
        List.of(111.0, 333.0, 222.0)
    );

    for (int i = 0; i < badInputs.size(); i++){
      car.sensorInput(
          SensorType.LIDARLEFT, badInputs.get(i).get(0), Weather.SUNNY
      );
      car.sensorInput(
          SensorType.LIDARCENTRE, badInputs.get(i).get(1), Weather.SUNNY
      );
      car.sensorInput(
          SensorType.LIDARRIGHT, badInputs.get(i).get(2), Weather.SUNNY
      );

      assert
          Display.LIST_OF_ALERTS.contains("2oo3 failed. Lidar do not agree.");

      assert (i + 1) % 3 != 0
          || Display.LIST_OF_ALERTS.contains("Lidar is incorrect 3 times. "
          + "Removing and adding new one.")
          : "Failed at Iteration: " + (i + 1);
    }
  }
}
