package com.example.problem;

/**
 * Created by user50 on 22.12.2014.
 */
public class NormalRandomGenerator {

    private double dispersion;
    private double mean;

    public NormalRandomGenerator(double dispersion, double mean) {
        this.dispersion = dispersion;
        this.mean = mean;
    }

    public double generate()
    {
        double normalRandomValue = 0;
        for (int i = 0; i < 6; i++) {
            normalRandomValue+=Math.random()-0.5;
        }

        return mean + normalRandomValue * dispersion / 6;
    }

    public double getMean() {
        return mean;
    }
}
