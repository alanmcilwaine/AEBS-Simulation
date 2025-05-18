package fixit_pioneers.ControlSignals;

public interface ControlSignals {
    double speed = 0.0;
    double brakePower = 0.75;

    public void processSensorData(SensorType sensor, double power);
    public void processUserInput(Action action, double power);

    default void triggerAntiBrakeLock(){}

    public void makeAnAction();
}

/**
 * "Mock Objects" to make the code compile.
 */
record SensorType(){}
record Action(){}