package fixit.simulation;

import com.fixit.car.Car;
import com.fixit.car.sensors.SensorType;
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
        List.of(20.0, 150.0, 300.0)
    );

    for (int i = 0; i < 10; i++){
      for (List<Double> badInput : badInputs) {
        car.sensorInput(SensorType.LIDARLEFT, badInput.get(0), Weather.SUNNY);
        car.sensorInput(SensorType.LIDARCENTRE, badInput.get(1), Weather.SUNNY);
        car.sensorInput(SensorType.LIDARRIGHT, badInput.get(2), Weather.SUNNY);
      }
    }

  }
}