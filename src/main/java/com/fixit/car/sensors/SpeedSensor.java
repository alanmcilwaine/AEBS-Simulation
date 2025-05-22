package com.fixit.car.sensors;

/**
 * 
 * 
 * 
 * 
 */
public interface SpeedSensor extends Sensor {
    /**
     * 
     * 
     * @return 
     */
    void sendToControlSignal();

    /**
     * 
     * 
     * @return 
     */
    void sendToInterface();
}
