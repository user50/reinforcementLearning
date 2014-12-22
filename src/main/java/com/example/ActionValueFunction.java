package com.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user50 on 22.12.2014.
 */
public class ActionValueFunction {

    private Map<Integer,Double> actionValueTable = new HashMap<Integer, Double>();
    private Map<Integer,Integer> attempts = new HashMap<Integer, Integer>();

    public ActionValueFunction(int machineNumber) {
        for (int machine = 0; machine < machineNumber; machine++) {
            actionValueTable.put(machine, 0.0);
            attempts.put(machine,0);
        }
    }

    public double asses(int numberOfMachine)
    {
        return actionValueTable.get(numberOfMachine);
    }

    public void adapt(int machine, double value) {
        double totalValue = actionValueTable.get(machine) * attempts.get(machine) + value;
        int totalAttempts = attempts.get(machine) + 1;

        actionValueTable.put(machine, totalValue/totalAttempts);
        attempts.put(machine, totalAttempts);
    }
}
