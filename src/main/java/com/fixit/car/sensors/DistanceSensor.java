package com.fixit.car.sensors;

/**
 * 
 * 
 * 
 * 
 */
public interface DistanceSensor extends Sensor {
    /**
     * 
     * 
     * @return 
     */
    void sendToAEBS(SensorType sensor, Double data);
}
