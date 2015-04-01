package com.example.montecarlo;

import com.example.common.*;
import com.example.common.table.TableFunction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user50 on 18.01.2015.
 */
public class MKFirstVisitMethod< S extends State,A extends Action> {

    Simulator<S,A> simulator;
    int maxIterations;
    double gamma;

    public MKFirstVisitMethod(Simulator<S, A> simulator, int maxIterations, double gamma) {
        this.simulator = simulator;
        this.maxIterations = maxIterations;
        this.gamma = gamma;
    }

    public <Arg> UpdatableFunction<Arg> execute(Strategy<S,A> strategy, ArgumentBuilder<Arg> argumentBuilder, UpdatableFunction<Arg> updatableFunction)
    {
        for (int iteration=0; iteration<maxIterations; iteration++) {
            List<Step<S,A>> episode = simulator.generateEpisode(strategy);

            double totalReward = 0;
            for (int i = 0; i < episode.size(); i++) {
                Step<S,A> step = episode.get(episode.size() - i - 1);
                totalReward = step.getReward() + gamma * totalReward;

                Arg arg = argumentBuilder.build(step);

                updatableFunction.update(arg, totalReward);
            }


        }

        return updatableFunction;

    }

}
