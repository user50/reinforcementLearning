package com.example;

import com.example.problem.NArmedBanditProblem;
import com.example.problem.NArmedBanditProblemBuilder;
import com.example.problem.NormalRandomGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user50 on 22.12.2014.
 */
public class Simulator {

    private int machineNumber;
    private int numberIteration;
    private double exploration;

    NArmedBanditProblem problem;

    public Simulator(int machineNumber, int numberIteration, double exploration, NArmedBanditProblem problem) {
        this.machineNumber = machineNumber;
        this.numberIteration = numberIteration;
        this.exploration = exploration;
        this.problem = problem;
    }

    public List<ActionResult> simulate()
    {

        ActionValueFunction actionValueFunction = new ActionValueFunction(machineNumber);
        Strategy strategy = new Strategy(actionValueFunction, machineNumber, exploration);

        int best = problem.getBest();

        List<ActionResult> results = new ArrayList<ActionResult>();

        for (int i = 0; i<numberIteration; i++)
        {
            int machine = strategy.getAction();
            double value = problem.pullHandle(machine);
            actionValueFunction.adapt(machine, value);

            results.add(new ActionResult(value, machine == best ? 1 : 0 ));

        }

        return results;
    }
}
