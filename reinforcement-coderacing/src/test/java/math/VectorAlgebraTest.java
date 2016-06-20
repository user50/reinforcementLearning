package math;

import org.junit.Test;

import static org.junit.Assert.*;

public class VectorAlgebraTest {

    @Test
    public void testName() throws Exception {
        VectorAlgebra.angle(new Vector(1,0), new Vector(1,1));
        LogScale.index(VectorAlgebra.angle(new Vector(1,0), new Vector(1,1)), 0.02, 0.4, 3 );

    }
}