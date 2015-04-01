package com.example.common.table;

import java.util.Map;

/**
 * Created by user50 on 29.01.2015.
 */
public class ExponentialMeanStrategy<Arg> implements UpdateTableStrategy<Arg>{

    private double alpha;

    public ExponentialMeanStrategy(double alpha) {
        this.alpha = alpha;
    }

    @Override
    public void update(Map<Arg, Double> table, Arg argument, double value) {
        if (!table.containsKey(argument))
            table.put(argument, 0.0);

        double currentValue = table.get(argument);
        double nextValue = currentValue + alpha * (value - currentValue);

        table.put(argument, nextValue);
    }
}
