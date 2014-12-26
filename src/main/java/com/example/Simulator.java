package com.example;

import com.example.learning.Strategy;
import com.example.problem.NArmedBanditProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user50 on 22.12.2014.
 */
public class Simulator {

    private int numberIteration;

    NArmedBanditProblem problem;
    Strategy strategy;

    public Simulator( int numberIteration, NArmedBanditProblem problem, Strategy strategy) {
        this.numberIteration = numberIteration;
        this.problem = problem;
        this.strategy = strategy;
    }

    public List<ActionResult> simulate()
    {
        int best = problem.getBest();

        List<ActionResult> results = new ArrayList<ActionResult>();

        for (int i = 0; i<numberIteration; i++)
        {
            int machine = strategy.getAction();
            double value = problem.pullHandle(machine);

            strategy.adapt(machine, value);

            results.add(new ActionResult(value, machine == best ? 1 : 0 ));

        }

        return results;
    }
}
