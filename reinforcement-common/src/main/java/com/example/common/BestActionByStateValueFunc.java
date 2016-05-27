package com.example.common;

import com.example.common.*;
import com.example.dp.FindBestActionOperation;
import com.example.dp.accessors.AccessActionByStateValueFunction;

/**
 * Created by user50 on 18.01.2015.
 */
public class BestActionByStateValueFunc<S extends State, A extends Action> implements FindBestActionOperation<S,A> {
    TransitionModel<S,A> transitionModel;
    RewardModel<S,A> rewardModel;
    UpdatableFunction<S> stateValueFunction;
    double gamma;

    public BestActionByStateValueFunc(TransitionModel<S, A> transitionModel, RewardModel<S, A> rewardModel, UpdatableFunction stateValueFunction, double gamma) {
        this.transitionModel = transitionModel;
        this.rewardModel = rewardModel;
        this.stateValueFunction = stateValueFunction;
        this.gamma = gamma;
    }

    public A find(S state)
    {
        double best = -Double.MAX_VALUE;
        A bestAction = null;

        AccessActionByStateValueFunction<S,A> accessAction = new AccessActionByStateValueFunction<S, A>(stateValueFunction, transitionModel, rewardModel, gamma);

        for (A action : transitionModel.getPossibleActions(state))
        {
            double expectedTotalReward = accessAction.access(state, action);

            if (expectedTotalReward > best)
            {
                best = expectedTotalReward;
                bestAction = action;
            }
        }

        return bestAction;
    }
}
