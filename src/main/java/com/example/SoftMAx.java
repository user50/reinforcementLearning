package com.example;

/**
 * Created by user50 on 26.12.2014.
 */
public class SoftMax {

    public int generate(double[] values)
    {
        double[] cumulativeSum = new double[values.length+1];
        cumulativeSum[0] = 0;

        for (int i = 0; i < values.length; i++) {
            cumulativeSum[i+1] = cumulativeSum[i] + values[i];
        }

        double randomValue = Math.random() * cumulativeSum[cumulativeSum.length-1];


        for (int i = 0; i < cumulativeSum.length -1; i++) {
            if(randomValue < cumulativeSum[i+1])
                return i;
        }

        throw new RuntimeException("Unable to generate index by softMax method");
    }
}
