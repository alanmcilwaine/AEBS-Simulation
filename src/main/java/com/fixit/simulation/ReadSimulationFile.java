package com.fixit.simulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Reads a simulation datafile and store it.
 *
 * @author Ming Bao
 */
public class ReadSimulationFile {
  /**
   * 2D array for storing sensor data. Inner array should have only 3 elements.
   * e.g:
   * [[0, 0, 0]
   * [1, 1, 1]
   * [2, 2, 2]]
   */
  private List<List<Double>> sensorData;
  /**
   * Weather enum for setting the weather of the simulation.
   */
  private Weather weather;
  /**
   * Path to the simulation data file.
   */
  private final Path filePath;
  /**
   * The initial speed of the car.
   */
  private Double initSpeed;

  /**
   * Constructs a ReadSimulationFile object with the path to a datafile.
   *
   * @param path The path of the datafile
   */
  public ReadSimulationFile(final String path) {
    this.filePath = Paths.get(path);
  }

  /**
   * Reads the data in the file and store the weather and sensor data
   * in their respective variables.
   */
  public void readData() {
    try {
      List<String> content = Files.readAllLines(filePath);
      content.removeIf(String::isEmpty);
      setWeather(content.removeFirst());
      this.initSpeed = Double.parseDouble(content.removeFirst());

      this.sensorData = content.stream()
          .map(c -> Arrays
              .stream(c.split(" "))
              .map(Double::parseDouble)
              .toList())
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
  private void setWeather(final String w) {
    assert !w.isEmpty() : "weather cannot be empty";
    String lowerW = w.toLowerCase();
    switch (lowerW) {
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

  /**
   * Getter for initSpeed variable.
   *
   * @return initSpeed.
   */
  public Double initSpeed() {
    return this.initSpeed;
  }
}
