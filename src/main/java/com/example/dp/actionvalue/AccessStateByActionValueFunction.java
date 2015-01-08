package com.example.dp.actionvalue;

import com.example.common.*;

/**
 * Created by user50 on 07.01.2015.
 */
public class AccessStateByActionValueFunction<S extends State, A extends Action> {

    TransitionModel<S,A> transitionModel;
    Strategy<S, A> strategy;
    ActionValueFunction<S, A> actionValueFunction;

    public AccessStateByActionValueFunction(TransitionModel<S, A> transitionModel,
                                            Strategy<S, A> strategy,
                                            ActionValueFunction<S, A> actionValueFunction) {
        this.transitionModel = transitionModel;
        this.strategy = strategy;
        this.actionValueFunction = actionValueFunction;
    }

    public double access(S state, A action)
    {
        double expectedTotalReward = 0;
        for (A action : transitionModel.getPossibleActions(state))
            expectedTotalReward += strategy.calculate(state, action) * actionValueFunction.access(state, action);

        return expectedTotalReward;
    }
}
