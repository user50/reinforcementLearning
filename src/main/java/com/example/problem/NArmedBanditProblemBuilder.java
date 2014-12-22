package com.example.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user50 on 22.12.2014.
 */
public class NArmedBanditProblemBuilder {

    private int machineNumbers;
    private NormalRandomGenerator dispersionGenerator;
    private NormalRandomGenerator meanGenerator;

    public NArmedBanditProblemBuilder(int machineNumbers, NormalRandomGenerator dispersionGenerator, NormalRandomGenerator meanGenerator) {
        this.machineNumbers = machineNumbers;
        this.dispersionGenerator = dispersionGenerator;
        this.meanGenerator = meanGenerator;
    }

    public NArmedBanditProblem build()
    {
        List<FruitMachine> machines = new ArrayList<FruitMachine>();

        for (int i = 0; i < machineNumbers; i++) {
            machines.add(new FruitMachine(new NormalRandomGenerator(dispersionGenerator.generate(), meanGenerator.generate())));
        }

        return new NArmedBanditProblem(machines);
    }

}
