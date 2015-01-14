package com.example.solving;

import com.example.common.*;
import com.example.dp.AccessState;
import com.example.dp.TableStateValueFunction;

import java.util.Map;

/**
 * Created by user50 on 14.01.2015.
 */
public class StateBelmanEquationSystem<S extends State, A extends Action> implements EquationSystem<S> {

    TransitionModel<S,A> transitionModel;
    RewardModel<S,A> rewardModel;
    Strategy<S,A> strategy;
    double gamma;

    public StateBelmanEquationSystem(TransitionModel<S, A> transitionModel, RewardModel<S, A> rewardModel, Strategy<S, A> strategy, double gamma) {
        this.transitionModel = transitionModel;
        this.rewardModel = rewardModel;
        this.strategy = strategy;
        this.gamma = gamma;
    }

    @Override
    public double calculate(S state, Map<S, Double> variables) {
        return new AccessState<S,A>(transitionModel, rewardModel, strategy, new TableStateValueFunction<S>(variables), gamma).accessTotalReward(state);
    }
}
