package com.example.montecarlo;

import com.example.common.Action;
import com.example.common.State;
import com.example.common.Strategy;
import com.example.common.UpdatableFunction;

import java.util.List;

public class TimeDifferenceMethod< S extends State,A extends Action> {

    Simulator<S,A> simulator;
    int maxIterations;
    double gamma;

    public TimeDifferenceMethod(Simulator<S, A> simulator, int maxIterations, double gamma) {
        this.simulator = simulator;
        this.maxIterations = maxIterations;
        this.gamma = gamma;
    }

    public UpdatableFunction<S> execute(Strategy<S,A> strategy, UpdatableFunction<S> updatableFunction)
    {
        for (int iteration=0; iteration<maxIterations; iteration++) {
            List<Step<S,A>> episode = simulator.generateEpisode(strategy);

            for (int i = 0; i < episode.size(); i++) {
                Step<S,A> step = episode.get(episode.size() - i - 1);

                double nextStateExpectedReward = updatableFunction.calculate(step.getNextState());

                updatableFunction.update(step.getState(), step.getReward() + gamma * nextStateExpectedReward);
            }


            System.out.println("");
        }

        return updatableFunction;

    }

}
