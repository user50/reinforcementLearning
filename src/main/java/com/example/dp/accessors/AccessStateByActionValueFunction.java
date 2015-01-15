package com.example.dp.accessors;

import com.example.common.*;

/**
 * Created by user50 on 15.01.2015.
 */
public class AccessStateByActionValueFunction<S extends State, A extends Action> {

    TransitionModel<S,A> transitionModel;
    UpdatableFunction<StateAction<S,A>> actionValueFunction;
    Strategy<S,A> strategy;

    public AccessStateByActionValueFunction(TransitionModel<S, A> transitionModel, UpdatableFunction<StateAction<S, A>> actionValueFunction, Strategy<S, A> strategy) {
        this.transitionModel = transitionModel;
        this.actionValueFunction = actionValueFunction;
        this.strategy = strategy;
    }

    public double access(S state)
    {
        double expectedTotalReward = 0;
        for (A action : transitionModel.getPossibleActions(state))
            expectedTotalReward += strategy.calculate(state, action) * actionValueFunction.calculate(new StateAction<S, A>(state, action));

        return expectedTotalReward;
    }
}
