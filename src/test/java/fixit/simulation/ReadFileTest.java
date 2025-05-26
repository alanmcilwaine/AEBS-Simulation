package fixit.simulation;

import org.junit.jupiter.api.Test;
import com.fixit.simulation.ReadSimulationFile;
import com.fixit.simulation.Weather;
import java.util.List;

public class ReadFileTest {

  @Test
  public void testRead() {
    ReadSimulationFile file = new ReadSimulationFile("src/test/java/fixit/simulation/testfile/readtest.txt");
    file.readData();

    assert file.weather() == Weather.SUNNY : "Read weather does not match: " + file.weather();
    for (int i = 0; i <= 2; i++) {
      List<Double> row = file.sensorData().get(i);
      for (Double d : row) {
        assert d == i : "row read failure: " + i;
      }
    }
  }
}
