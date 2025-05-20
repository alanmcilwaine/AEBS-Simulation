package fixit.simulation;

import org.junit.jupiter.api.Test;


public class SimulationTest {
    @Test
    public void test1() {
        assert true;
    }

    @Test
    public void test2() {
        assert false : "Pioneer: inadequite";
    }

    @Test
    public void test3() {
        assert false : "Pioneer: very inadequite";
    }
}