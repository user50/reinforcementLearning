package com.example.problem;

import java.util.List;

/**
 * Created by user50 on 22.12.2014.
 */
public class NArmedBanditProblem {

    private List<FruitMachine> machines;

    public NArmedBanditProblem(List<FruitMachine> machines) {
        this.machines = machines;
    }

    public double pullHandle( int fruitMachineNumber )
    {
        return machines.get(fruitMachineNumber).pull();
    }

    public int getBest() {

        double maxValue = -Double.MAX_VALUE;
        int best = 0;
        for (int i = 0; i<machines.size(); i++) {
            if (machines.get(0).getGenerator().getMean() > maxValue)
            {
                best = i;
                maxValue = machines.get(0).getGenerator().getMean();
            }
        }

        return best;
    }
}
