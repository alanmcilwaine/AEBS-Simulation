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
  private String weather;
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
      this.weather = content.remove(0);
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
   * Getter for weather variable
   *
   * @return weather
   */
  public String weather() {
    return this.weather;
  }

  /**
   * Getter for sensorData variable
   *
   * @return sensorData
   */
  public List<List<Double>> sensorData() {
    return this.sensorData;
  }
}
