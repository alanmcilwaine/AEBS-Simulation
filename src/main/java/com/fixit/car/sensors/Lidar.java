package com.fixit.car.sensors;

import com.fixit.aebs.Aebs;
import com.fixit.simulation.Weather;

/**
 * 
 * 
 * 
 * 
 */
public class Lidar implements DistanceSensor {
    /**
     * Storing the Lidar measurement.
     */
    private double data = 0;

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

    @Override
    public void sendToAEBS(SensorType sensor, Double data, Weather weather) {
        Aebs.instance().receiveDistanceAebs(data);
    }

    @Override
    public int readData(SensorType sensor, Double data, Weather weather) {
        sendToAEBS(sensor, data, weather);
        return 1;
    }
    
}
