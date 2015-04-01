package com.example.solving;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user50 on 14.01.2015.
 */
public class Solver<Arg> {

    private EquationSystem<Arg> equationSystem;
    private double errorTolerance;

    public Solver(EquationSystem<Arg> equationSystem, double errorTolerance) {
        this.equationSystem = equationSystem;
        this.errorTolerance = errorTolerance;
    }

    public Map<Arg,Double> solve(Map<Arg,Double> initVariables)
    {
        Map<Arg,Double> solution = new HashMap<Arg, Double>(initVariables);

        boolean stop;

        do {
            double maxError = 0;
            for (Arg variable : solution.keySet()) {
                double currentValue = solution.get(variable);
                double nextValue = equationSystem.calculate(variable, solution);

                solution.put(variable, equationSystem.calculate(variable, solution));

                maxError = Math.max(maxError, Math.abs(currentValue - nextValue));
            }

            stop = maxError < errorTolerance;

        } while (!stop);

        return solution;
    }
}
