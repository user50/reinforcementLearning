package com.coderacing.math.regression;

import java.util.Map;

/**
 * Created by user50 on 12.10.2014.
 */
public class SimplePow implements Regressor {

    private String name;
    private double pow;

    public SimplePow(String name, double pow) {
        this.name = name;
        this.pow = pow;
    }

    @Override
    public double calculate(Map<String, Double> variables) {
        return Math.pow(variables.get(name), pow);
    }
}