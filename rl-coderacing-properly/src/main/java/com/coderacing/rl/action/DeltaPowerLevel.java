package com.coderacing.rl.action;

public enum DeltaPowerLevel {
    maximal(0.025), zero(0) ;

    private double value;

    DeltaPowerLevel(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
