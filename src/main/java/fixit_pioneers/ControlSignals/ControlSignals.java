package fixit_pioneers.ControlSignals;

public interface ControlSignals {
    double speed = 0.0;
    double brakePower = 0.75;

    /**
     *
     * @param sensor
     * @param power
     */
    public void processSensorData(SensorType sensor, double power);

    /**
     *
     * @param action
     * @param power
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