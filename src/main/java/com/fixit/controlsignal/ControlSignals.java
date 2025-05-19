package com.fixit.controlsignal;

public interface ControlSignals {
    /** The current speed of the car. */
    double speed = 0.0;

    /** The current power of the brakes being applied. */
    double brakePower = 0.0;

    /**
     * Takes a given car sensor, and processes the data in it.
     *
     * @param sensor The car sensor of interest, that holds the data.
     * @param power The brake power to apply to the car.
     */
    void processSensorData(SensorType sensor, double power);

    /**
     * Processes user input.
     *
     * @param action The action that the car brakes will take.
     * @param power The brake power to apply to the car.
     */
    void processUserInput(Action action, double power);

    /**
     * To prevent the wheels from locking up during braking, the Anti-Lock
     * Brake system will activate automatically.
     */
    default void triggerAntiBrakeLock() {}

    /** Make an action! (Not sure what it does at this stage.) */
    void makeAnAction();
}

/** "Mock Objects" to make the code compile. */
record SensorType() {}
record Action() {}

