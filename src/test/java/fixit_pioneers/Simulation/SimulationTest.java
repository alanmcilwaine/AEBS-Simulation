package fixit_pioneers.Simulation;

import org.junit.Test;

public class SimulationTest {
    
    @Test
    public void test1(){
        assert true;
    }

    @Test
    public void test2(){
        assert false : "Pioneer: inadequate";
    }

    @Test
    public void test3(){
        assert false : "Pioneer: very inadequate";
    }
}
