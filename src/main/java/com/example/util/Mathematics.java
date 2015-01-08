package com.example.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by user50 on 31.12.2014.
 */
public class Mathematics {

    public static List<Double> cumulativeSum(List<Double> values)
    {
        List<Double> result = new ArrayList<Double>();
        result.add(values.get(0));

        for (int i = 1; i < values.size(); i++)
            result.add(result.get(i -1) + values.get(i));

        return values;
    }

    public static double mean(List<Double> value) {
        double sum = 0;
        for (Double aDouble : value)
            sum+=aDouble;

        return sum / value.size();
    }

    public static int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
