package com.example.dp;

import com.example.common.*;
import com.example.dp.statevalue.AccessStateByStateValueFunction;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import java.util.List;

/**
 * Created by user50 on 06.01.2015.
 */
public class StateValueFunctionAccessor<S extends State, A extends Action> {

    List<S> nonTerminalStates;
    TransitionModel<S,A> transitionModel;
    RewardModel<S,A> rewardModel;
    double gamma;
    double errorTolerance;

    @Inject
    public StateValueFunctionAccessor(@Named("nonTerminalStates")List<S> nonTerminalStates,
                                      TransitionModel<S, A> transitionModel,
                                      RewardModel<S, A> rewardModel,
                                      @Named("gamma") double gamma,
                                      @Named("errorTolerance") double errorTolerance) {
        this.nonTerminalStates = nonTerminalStates;
        this.transitionModel = transitionModel;
        this.rewardModel = rewardModel;
        this.gamma = gamma;
        this.errorTolerance = errorTolerance;
    }

    public StateValueFunction<S> access(Strategy<S, A> strategy, StateValueFunction<S> stateValueFunction)
    {
        AccessStateByStateValueFunction<S, A> accessor =
                new AccessStateByStateValueFunction<S, A>(transitionModel, rewardModel, strategy, stateValueFunction, gamma);

        boolean stop;

        do {
            double maxError = 0;

            for (S state : nonTerminalStates) {
                double currentValue = stateValueFunction.calculate(state);
                double nextValue = accessor.accessTotalReward(state,strategy, stateValueFunction );
                stateValueFunction.update(state, nextValue);

                maxError = Math.max(maxError, Math.abs(currentValue - nextValue));
            }

            stop = maxError < errorTolerance;
        }while (!stop);

        return stateValueFunction;
    }
}
