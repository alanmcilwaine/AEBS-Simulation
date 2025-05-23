package com.fixit.car.sensors;

import com.fixit.aebs.AEBS;

/**
 * 
 * 
 * 
 * 
 */
public class Lidar implements DistanceSensor {

    @Override
    public void sendToAEBS(SensorType sensor, Double data) {
        AEBS.evaluateBraking(sensor, data);
    }

    @Override
    public int readData(SensorType sensor, Double data, Weather weather) {
        sendToAEBS(sensor, data);
        return 1;
    }
    
}
