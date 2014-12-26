package com.example.learning;

/**
 * Created by user50 on 26.12.2014.
 */
public class LinearCooling implements Cooling {

    private double temperature;

    private int iteration = 0;

    public LinearCooling(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public double cool() {
        return temperature / ++iteration;
    }
}
