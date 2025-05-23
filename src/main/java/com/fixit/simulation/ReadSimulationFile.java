package com.fixit.simulation;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Reads a simulation datafile and store it.
 *
 * @author Ming Bao
 */
public class ReadSimulationFile {
  private List<List<Double>> sensorData;
  private Weather weather;
  private Path filePath;

  /**
   * Constructs a ReadSimulationFile object with the path to a datafile.
   *
   * @param filePath The path of the datafile
   */
  public ReadSimulationFile(String filePath) {
    this.filePath = Paths.get(filePath);
  }

  /**
   * Reads the data in the file and store the weather and sensor data
   * in their respective variables.
   */
  public void readData() {
    try {
      List<String> content = Files.readAllLines(filePath);
      content.removeIf(e -> e.isEmpty());
      setWeather(content.removeFirst());

      this.sensorData = content.stream()
          .map((c) -> {
            return Arrays.asList(c.split(" "))
                .stream()
                .map(Double::parseDouble)
                .toList();
          })
          .toList();
    } catch (IOException e) {
      throw new Error("Error reading file");
    }
  }

  /**
   * Inputs a weather string and turns it into a weather enum and stores it.
   *
   * @param w The weather string.
   * @throws AssertionError if the string is empty or of the string
   *                        is not one of the defined weather.
   */
  private void setWeather(String w) {
    assert !w.isEmpty() : "weather cannot be empty";
    w = w.toLowerCase();
    switch (w) {
      case "sunny":
        this.weather = Weather.SUNNY;
        break;
      case "rainy":
        this.weather = Weather.RAINY;
        break;
      case "foggy":
        this.weather = Weather.FOGGY;
        break;
      default:
        assert false : "Weather out of bounds";
        break;
    }
  }

  /**
   * Getter for weather variable.
   *
   * @return weather.
   */
  public Weather weather() {
    return this.weather;
  }

  /**
   * Getter for sensorData variable.
   *
   * @return sensorData.
   */
  public List<List<Double>> sensorData() {
    return this.sensorData;
  }
}
