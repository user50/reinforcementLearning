package com.example.learning;

import com.example.SoftMax;

/**
 * Created by user50 on 26.12.2014.
 */
public class SoftMaxStrategy implements Strategy {

    private ActionValueFunction actionValueFunction;
    private int numberOfMachine;
    private Cooling cooling;

    public SoftMaxStrategy(ActionValueFunction actionValueFunction, int numberOfMachine, Cooling cooling) {
        this.actionValueFunction = actionValueFunction;
        this.numberOfMachine = numberOfMachine;
        this.cooling = cooling;
    }

    @Override
    public int getAction() {
        double[] probabilities = new double[numberOfMachine];
        for (int machine = 0; machine < numberOfMachine; machine++) {
            double assets = actionValueFunction.asses(machine);
            probabilities[machine] = Math.exp(assets / cooling.cool());
        }

        return new SoftMax().generate(probabilities);
    }

    @Override
    public void adapt(int machine, double value) {
        actionValueFunction.adapt(machine, value);
    }
}
