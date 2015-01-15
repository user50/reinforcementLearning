package com.example.dp.accessors;

import com.example.common.*;

/**
 * Created by user50 on 15.01.2015.
 */
public class AccessActionByActionValueFunction<S extends State, A extends Action> {

    TransitionModel<S,A> transitionModel;
    UpdatableFunction<StateAction<S,A>> actionValueFunction;
    Strategy<S,A> strategy;
    RewardModel<S,A> rewardModel;
    double gamma;

    public double access(S state, A action)
    {
        AccessStateByActionValueFunction<S,A> accessState =
                new AccessStateByActionValueFunction<S, A>(transitionModel, actionValueFunction, strategy);

        double expectedTotalReward = 0;
        for (S possibleNextState : transitionModel.getPossibleStates(state, action)) {
            expectedTotalReward += transitionModel.calculate(state, action, possibleNextState) *
                    ( rewardModel.calculate(state, action, possibleNextState) + gamma * accessState.access(possibleNextState) );
        }

        return expectedTotalReward;
    }
}
