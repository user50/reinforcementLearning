package com.example;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by user50 on 26.12.2014.
 */
public class SoftMaxTest {

    @Test
    public void testAcceptOne() throws Exception {
        double[] probabilities = new double[]{0, 1, 0};
        SoftMax softMax = new SoftMax();

        int index = softMax.generate(probabilities);

        Assert.assertEquals(1, index);
    }

    @Test
    public void testAcceptTwo() throws Exception {
        double[] probabilities = new double[]{0, 0, 1};
        SoftMax softMax = new SoftMax();

        int index = softMax.generate(probabilities);

        Assert.assertEquals(2, index);
    }

    @Test
    public void testAcceptThree() throws Exception {
        double[] probabilities = new double[]{0, 1, 1};
        SoftMax softMax = new SoftMax();

        int index = softMax.generate(probabilities);

        Assert.assertTrue(new HashSet<Integer>(Arrays.asList(1, 2)).contains(index)) ;
    }
}
