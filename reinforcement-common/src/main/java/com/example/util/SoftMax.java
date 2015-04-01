package com.example.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SoftMax {

    public static <T> T generate(Map<T,Double> distribution)
    {
        List<T> arguments = new ArrayList<T>();
        List<Double> probabilities = new ArrayList<Double>();

        for (Map.Entry<T, Double> entry : distribution.entrySet()) {
            arguments.add(entry.getKey());
            probabilities.add(entry.getValue());
        }

        return arguments.get(generate(probabilities));
    }

    public static int generate(List<Double> doubles)
    {
        double[] values = new double[doubles.size()];

        for (int i = 0; i < doubles.size(); i++)
            values[i] = doubles.get(i);

        return generate(values);
    }

    public static int generate(double[] values)
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