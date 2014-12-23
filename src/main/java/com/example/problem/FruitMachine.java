package com.example.problem;

/**
 * Created by user50 on 22.12.2014.
 */
public class FruitMachine {

    private NormalRandomGenerator generator;

    public FruitMachine(NormalRandomGenerator generator) {
        this.generator = generator;
    }

    public double pull()
    {
        return generator.generate();
    }

    public NormalRandomGenerator getGenerator() {
        return generator;
    }
}
