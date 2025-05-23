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
    void sendToControlSignal(SensorType sensor, Double data);

    /**
     * 
     * 
     * @return 
     */
    void sendToInterface(Double data);
}
