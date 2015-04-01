package com.example.common;

import com.example.common.*;
import com.example.dp.FindBestActionOperation;

/**
 * Created by user50 on 18.01.2015.
 */
public class BestActionByActionValueFunc<S extends State, A extends Action> implements FindBestActionOperation<S,A> {

    TransitionModel<S,A> transitionModel;
    UpdatableFunction<StateAction<S,A>> stateValueFunction;

    public BestActionByActionValueFunc(TransitionModel<S, A> transitionModel, UpdatableFunction<StateAction<S, A>> stateValueFunction) {
        this.transitionModel = transitionModel;
        this.stateValueFunction = stateValueFunction;
    }

    @Override
    public A find(S state) {

        double bestTotalReward = -Double.MAX_VALUE;
        A bestAction = null;

        for (A action : transitionModel.getPossibleActions(state)) {
            double expectedReward = stateValueFunction.calculate(new StateAction<S, A>(state, action));

            if (expectedReward > bestTotalReward)
            {
                bestTotalReward = expectedReward;
                bestAction = action;
            }
        }

        if (bestAction == null)
            throw new NullPointerException();

        return bestAction;
    }
}
