package com.example;

import com.example.problem.NArmedBanditProblem;
import com.example.problem.NArmedBanditProblemBuilder;
import com.example.problem.NormalRandomGenerator;

/**
 * Created by user50 on 22.12.2014.
 */
public class Main {

    public static void main(String[] args) {
        int machineNumber = 10;

        NArmedBanditProblemBuilder builder = new NArmedBanditProblemBuilder(machineNumber, new NormalRandomGenerator(0, 3), new NormalRandomGenerator(1,1));

        NArmedBanditProblem problem = builder.build();

        ActionValueFunction actionValueFunction = new ActionValueFunction(machineNumber);
        Strategy strategy = new Strategy(actionValueFunction, machineNumber, 0.9);

        double totalValue = 0;
        for (int i = 0; i<2000; i++)
        {
            int machine = strategy.getAction();
            double value = problem.pullHandle(machine);
            actionValueFunction.adapt(machine, value);

            totalValue += value;
        }

    }

}
