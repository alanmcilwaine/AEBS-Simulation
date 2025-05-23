package com.fixit.car.sensors;

/**
 * 
 * 
 * 
 * 
 */
public class Camera implements DistanceSensor {

    @Override
    public void sendToAEBS() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Double readData(SensorType sensor, Double data, Weather weather) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
