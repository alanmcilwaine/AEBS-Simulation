package fixit.car.sensors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import org.junit.jupiter.api.Test;
import java.lang.reflect.*;

import com.fixit.car.Car;
import com.fixit.car.sensors.Lidar;
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

  @Test
  public void T05RemoveLeft() {
    Car c = Car.instance();
    c.testRemoveLidar(0);

    try {
      Field field = Car.class.getDeclaredField("lidarSensors");
      field.setAccessible(true);

      @SuppressWarnings("unchecked")
      List<Lidar> lidars = (List<Lidar>) field.get(c);

      assertEquals(2, lidars.size(), "Did not successfully remove lidar");

      c.sensorInput(SensorType.LIDARLEFT, 0, Weather.SUNNY);
      c.sensorInput(SensorType.LIDARCENTRE, 0, Weather.SUNNY);
      c.sensorInput(SensorType.LIDARRIGHT, 0, Weather.SUNNY);

      assertEquals(3, lidars.size(), "Did not restore lidar");
    } catch (NoSuchFieldException | IllegalAccessException e) {
      e.printStackTrace();
      fail("Reflection failed: " + e.getMessage());
    }
  }

  @Test
  public void T05RemoveMiddle() {
    Car c = Car.instance();
    c.testRemoveLidar(0);

    try {
      Field field = Car.class.getDeclaredField("lidarSensors");
      field.setAccessible(true);

      @SuppressWarnings("unchecked")
      List<Lidar> lidars = (List<Lidar>) field.get(c);

      assertEquals(2, lidars.size(), "Did not successfully remove lidar");

      c.sensorInput(SensorType.LIDARLEFT, 0, Weather.SUNNY);
      c.sensorInput(SensorType.LIDARCENTRE, 0, Weather.SUNNY);
      c.sensorInput(SensorType.LIDARRIGHT, 0, Weather.SUNNY);

      assertEquals(3, lidars.size(), "Did not restore lidar");
    } catch (NoSuchFieldException | IllegalAccessException e) {
      e.printStackTrace();
      fail("Reflection failed: " + e.getMessage());
    }
  }

  @Test
  public void T05RemoveRight() {
    Car c = Car.instance();
    c.testRemoveLidar(0);

    try {
      Field field = Car.class.getDeclaredField("lidarSensors");
      field.setAccessible(true);

      @SuppressWarnings("unchecked")
      List<Lidar> lidars = (List<Lidar>) field.get(c);

      assertEquals(2, lidars.size(), "Did not successfully remove lidar");

      c.sensorInput(SensorType.LIDARLEFT, 0, Weather.SUNNY);
      c.sensorInput(SensorType.LIDARCENTRE, 0, Weather.SUNNY);
      c.sensorInput(SensorType.LIDARRIGHT, 0, Weather.SUNNY);

      assertEquals(3, lidars.size(), "Did not restore lidar");
    } catch (NoSuchFieldException | IllegalAccessException e) {
      e.printStackTrace();
      fail("Reflection failed: " + e.getMessage());
    }
  }
}
