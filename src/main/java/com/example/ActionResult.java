package com.example;

/**
 * Created by user50 on 23.12.2014.
 */
public class ActionResult {
    private double value;
    private int optimal;

    public ActionResult(double value, int optimal) {
        this.value = value;
        this.optimal = optimal;
    }

    public double getValue() {
        return value;
    }

    public int getOptimal() {
        return optimal;
    }
}
