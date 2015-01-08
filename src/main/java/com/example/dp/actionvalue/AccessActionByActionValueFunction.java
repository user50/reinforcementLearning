package com.example.dp.actionvalue;

import com.example.common.*;

/**
 * Created by user50 on 07.01.2015.
 */
public class AccessActionByActionValueFunction<S extends State, A extends Action> {

    TransitionModel<S,A> transitionModel;
    RewardModel<S,A> rewardModel;
    Strategy<S, A> strategy;
    ActionValueFunction<S, A> actionValueFunction;
    double gamma;

    public AccessActionByActionValueFunction(TransitionModel<S, A> transitionModel,
                                             RewardModel<S, A> rewardModel,
                                             Strategy<S, A> strategy,
                                             ActionValueFunction<S, A> actionValueFunction,
                                             double gamma) {
        this.transitionModel = transitionModel;
        this.rewardModel = rewardModel;
        this.strategy = strategy;
        this.actionValueFunction = actionValueFunction;
        this.gamma = gamma;
    }

    public double access(S state, A action)
    {
        AccessStateByActionValueFunction<S,A> accessState =
                new AccessStateByActionValueFunction<S, A>(transitionModel, strategy, actionValueFunction );

        double expectedTotalReward = 0;
        for (S possibleNextState : transitionModel.getPossibleStates(state, action)) {
            expectedTotalReward += transitionModel.calculate(state, action, possibleNextState) *
                    (rewardModel.calculate(state, action, possibleNextState) + gamma * accessState.access(possibleNextState));
        }

        return expectedTotalReward;
    }
}
