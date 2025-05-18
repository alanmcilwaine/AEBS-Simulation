package fixit_pioneers.ControlSignals;

public interface ControlSignals {
    double speed = 0.0;
    double brakePower = 0.75;

    /**
     * Takes a given car sensor, and processes the data in it.
     *
     * @param sensor The car sensor of interest, that holds the data.
     * @param power The brake power to apply to the car.
     */
    public void processSensorData(SensorType sensor, double power);

    /**
     * Processes user input.
     *
     * @param action The action that the car brakes will take.
     * @param power The brake power to apply to the car.
     */
    public void processUserInput(Action action, double power);

    /**
     * To prevent the wheels from locking up during braking, the Anti-Lock Brake system will activate automatically.
     */
    default void triggerAntiBrakeLock(){}

    public void makeAnAction();
}

/**
 * "Mock Objects" to make the code compile.
 */
record SensorType(){}
record Action(){}