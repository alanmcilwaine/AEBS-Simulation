package fixit.simulation;

import com.fixit.car.Car;
import com.fixit.car.sensors.SensorType;
import com.fixit.interfaces.Display;
import com.fixit.interfaces.UserInterface;
import com.fixit.simulation.Weather;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class R13Test {

  private final PrintStream originalOut = System.out;
  private ByteArrayOutputStream outContent;

  @BeforeEach
  public void setUp() {
    // Capture console output in a ByteArrayOutputStream.
    outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
  }

  @AfterEach
  public void tearDown() {
    // Restore the original System.out after each test.
    System.setOut(originalOut);
    // Clear any static state (such as error messages) so tests remain independent.
    Display.flushErrors();
  }

  @Test
  public void testErrorSoundPrinted() {
    // Resets the terminal so it is clear
    outContent.reset();
    //Flushes all the errors that are lingering in the List of errors
    Display.flushErrors();
    // When an error is added, errorsToShow calls errorSound which prints "Alert Appearing sound"
    Display.errorsToShow("Test error");

    // Get whatever was printed to the console.
    String printedOutput = outContent.toString();

    // Assert that the output contains "Alert Appearing sound"
    assertTrue(printedOutput.contains("Alert Appearing sound"),
            "Expected the output to include 'Alert Appearing sound'");
  }

  @Test
  public void T01() {
    outContent.reset();
    Display.flushErrors();

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

      String printedOutput = outContent.toString();

      assertTrue(printedOutput.contains("Alert Appearing sound"),
              "Expected the output to include 'Alert Appearing sound'");
    }

    for (List<Double> goodInput : goodInputs) {
      outContent.reset();
      Display.flushErrors();

      car.sensorInput(SensorType.LIDARLEFT, goodInput.get(0), Weather.SUNNY);
      car.sensorInput(SensorType.LIDARCENTRE, goodInput.get(1), Weather.SUNNY);
      car.sensorInput(SensorType.LIDARRIGHT, goodInput.get(2), Weather.SUNNY);

      String printedOutput = outContent.toString();
      assertFalse(printedOutput.contains("Alert Appearing sound"), "Expected no output, received " + printedOutput);
    }
  }

}