package com.fixit.car.sensors;

import com.fixit.simulation.Weather;

/**
 * 
 * 
 * 
 * 
 */
public class Radar implements DistanceSensor {

    @Override
    public void sendToAEBS(SensorType sensor, Double data, Weather weather) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int readData(SensorType sensor, Double data, Weather weather) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
