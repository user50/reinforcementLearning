package com.example;

/**
 * Created by user50 on 22.12.2014.
 */
public class EGreedyStrategy implements Strategy{
    private ActionValueFunction actionValueFunction;
    private int numberOfMachine;
    private double explorationProbability;

    public EGreedyStrategy(ActionValueFunction actionValueFunction, int numberOfMachine, double explorationProbability) {
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
            return bestMachine;
        }
        else
            return generateRandomAction();

    }

    @Override
    public void adapt(int machine, double value) {
        actionValueFunction.adapt(machine, value);
    }

    private int generateRandomAction()
    {
        return (int)(Math.random()*numberOfMachine);
    }
}
