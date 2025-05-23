package com.fixit.car.sensors;

import com.fixit.controlsignal.ControlSignals;

/**
 * 
 * 
 * 
 * 
 */
public class WheelSpeed implements SpeedSensor {

    @Override
    public void sendToControlSignal(SensorType sensor, Double data, Weather weather) {
        ControlSignals.processSensorData(sensor, data, weather);
    }

    @Override
    public void sendToInterface(Double data) {
        UserInterface.recieveSpeed(data);
    }

    @Override
    public int readData(SensorType sensor, Double data, Weather weather) {
        sendToControlSignal(sensor, data, weather);
        sendToInterface(data);
        return 1;
    }
    
}
