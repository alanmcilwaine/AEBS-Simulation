package com.fixit.simulation;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ReadSimulationFile {
  private List<List<Double>> sensorData;
  private String weather;
  private Path filePath;

  public ReadSimulationFile(String filePath) {
    this.filePath = Paths.get(filePath);
  }

  public void readData() {
    try {
      List<String> content = Files.readAllLines(filePath);
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
      System.out.println("Error reading file");
    }
  }
}
