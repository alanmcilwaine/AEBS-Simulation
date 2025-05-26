package fixit.simulation;

import com.fixit.car.Car;
import com.fixit.car.sensors.SensorType;
import com.fixit.interfaces.Display;
import com.fixit.interfaces.UserInterface;
import com.fixit.simulation.Weather;
import org.junit.jupiter.api.Test;

import java.util.List;

public class R06Test {

  public List<Double> goodTick() {
    return List.of(500.0, 500.0, 500.0);
  }

  public List<Double> anomalyTick() {
    return List.of(10.0, 10.0, 10.0);
  }
  @Test
  public void T11() {
    Car car = Car.instance();
    List<List<Double>> inputAnomaly = List.of(
            goodTick(),
            anomalyTick()
    );

    for(List<Double> input : inputAnomaly) {
      car.sensorInput(SensorType.LIDARLEFT, input.get(0), Weather.SUNNY);
      car.sensorInput(SensorType.LIDARCENTRE, input.get(1), Weather.SUNNY);
      car.sensorInput(SensorType.LIDARRIGHT, input.get(2), Weather.SUNNY);
    }

    assert Display.LIST_OF_ALERTS.contains("Sensor Anomaly Detected, check for hazards");
    UserInterface.removeWarning("2oo3 failed. Lidar do not agree.");
  }

}
