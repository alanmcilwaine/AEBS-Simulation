package com.fixit.car.sensors;

import com.fixit.aebs.Aebs;
import com.fixit.simulation.Weather;

/** 
* Sensor for sending lidar
* distance data to other packages
*/
public class Lidar implements DistanceSensor {
  /**
   * Sends distance information to AEBS package
   * 
   * @param sensor An enum representing the sensors type
   * @param data distance value to be sent
   * @param weather An enum representing weather status
   */
  @Override
  public void sendToAEBS(final SensorType sensor,
                         final Double data,
                         final Weather weather) {
    Aebs.instance().receiveDistanceAebs(data);
  }

  /**
    * Storing the Lidar measurement.
    */
  private double data = -1;

  /**
   * Storing how often this sensor has been incorrect.
   */
  private int incorrectCounter = 0;

  /**
   * Increase incorrectCounter by 1.
   */
  public void addIncorrectCounter() {
    incorrectCounter++;
  }

  /**
   * Getter for the incorrectCounter.
   *
   * @return Number of times the sensor has been incorrect.
   */
  public int incorrectCounter() {
    return incorrectCounter;
  }


  /**
    * Setter for the data variable.
    * @param inData The new data.
    */
  public void data(final double inData) {
    this.data = inData;
  }

  /**
    * Getter for data.
    * @return Returns the data variable.
    */
  public double data() {
    return this.data;
  }


  /**
   * Facilitates distance data 
   * distribution with sendToAEBS()
   * 
   * @param sensor An enum representing the sensors type
   * @param data Distance value to be sent
   * @param weather An enum representing weather status
   * @return 1 if successful
   */
  @Override
  public int readData(final SensorType sensor,
                      final Double data,
                      final Weather weather) {
    sendToAEBS(sensor, data, weather);
    return 1;
  }
}
