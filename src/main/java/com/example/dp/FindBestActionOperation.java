package com.example.dp;

import com.example.common.*;

/**
 * Created by user50 on 07.01.2015.
 */
public class FindBestActionOperation<S extends State, A extends Action> {

    TransitionModel<S,A> transitionModel;
    RewardModel<S,A> rewardModel;
    StateValueFunction<S> stateValueFunction;
    double gamma;

    public FindBestActionOperation(TransitionModel<S, A> transitionModel, RewardModel<S, A> rewardModel, StateValueFunction<S> stateValueFunction, double gamma) {
        this.transitionModel = transitionModel;
        this.rewardModel = rewardModel;
        this.stateValueFunction = stateValueFunction;
        this.gamma = gamma;
    }

    public A find(S state)
    {
        double best = -Double.MAX_VALUE;
        A bestAction = null;

        AccessAction<S,A> accessAction = new AccessAction<S, A>(stateValueFunction, transitionModel, rewardModel, gamma);

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
