package com.example.dp.equations;

import com.example.common.*;
import com.example.dp.accessors.AccessStateByStateValueFunction;
import com.example.common.table.TableFunction;
import com.example.solving.EquationSystem;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import java.util.Map;

/**
 * Created by user50 on 14.01.2015.
 */
public class StateBelmanEquationSystem<S extends State, A extends Action> implements EquationSystem<S> {

    TransitionModel<S,A> transitionModel;
    RewardModel<S,A> rewardModel;
    Strategy<S,A> strategy;
    double gamma;

    @Inject
    public StateBelmanEquationSystem(TransitionModel<S, A> transitionModel, RewardModel<S, A> rewardModel, Strategy<S, A> strategy, @Named("gamma") double gamma) {
        this.transitionModel = transitionModel;
        this.rewardModel = rewardModel;
        this.strategy = strategy;
        this.gamma = gamma;
    }

    @Override
    public double calculate(S state, Map<S, Double> variables) {
        return new AccessStateByStateValueFunction<S,A>(transitionModel, rewardModel, strategy, new TableFunction<S>(variables), gamma).accessTotalReward(state);
    }
}
