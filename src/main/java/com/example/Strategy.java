package com.example;

import com.example.ActionValueFunction;

/**
 * Created by user50 on 22.12.2014.
 */
public class Strategy {
    private ActionValueFunction actionValueFunction;
    private int numberOfMachine;
    private double explorationProbability;

    public Strategy(ActionValueFunction actionValueFunction, int numberOfMachine, double explorationProbability) {
        this.actionValueFunction = actionValueFunction;
        this.numberOfMachine = numberOfMachine;
        this.explorationProbability = explorationProbability;
    }

    public int getAction()
    {
        double maxValue = -Double.MAX_VALUE;
        int bestMachine = 0;
        for (int machine = 0; machine < numberOfMachine; machine++) {
            double value = actionValueFunction.asses(machine);
            if (value > maxValue)
            {
                maxValue = value;
                bestMachine = machine;
            }
        }

        if (Math.random() > explorationProbability) {
            return generateRandom(bestMachine);
        }
        else
            return bestMachine;

    }

    private int generateRandom(int exclude)
    {
        while (true)
        {
            int value = (int)(Math.random()*numberOfMachine);

            if (value != exclude)
                return value;
        }
    }
}
