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

    @Override
    public void sendToAEBS(SensorType sensor, Double data, Weather weather) {
        Aebs.receiveDistanceAebs(data);
    }

    @Override
    public int readData(SensorType sensor, Double data, Weather weather) {
        sendToAEBS(sensor, data, weather);
        return 1;
    }
    
}
