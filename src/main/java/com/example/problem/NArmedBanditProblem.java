package com.example.problem;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

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

        TreeSet<FruitMachine> set = new TreeSet<FruitMachine>(new Comparator<FruitMachine>(){
            @Override
            public int compare(FruitMachine o1, FruitMachine o2) {
                return new Double(o1.getGenerator().getMean()).compareTo(o2.getGenerator().getMean());
            }
        });

        set.addAll(machines);

        return machines.indexOf(set.last());
    }
}
