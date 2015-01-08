package com.example.dp.statevalue;

import com.example.common.*;

/**
 * Created by user50 on 07.01.2015.
 */
public class AccessActionByStateValueFunction<S extends State, A extends Action> {

    StateValueFunction<S> stateValueFunction;
    TransitionModel<S,A> transitionModel;
    RewardModel<S,A> rewardModel;
    double gamma;

    public AccessActionByStateValueFunction(StateValueFunction<S> stateValueFunction, TransitionModel<S, A> transitionModel, RewardModel<S, A> rewardModel, double gamma) {
        this.stateValueFunction = stateValueFunction;
        this.transitionModel = transitionModel;
        this.rewardModel = rewardModel;
        this.gamma = gamma;
    }

    public double access(S state, A action)
    {
        double expectedTotalReward = 0;
        for (S possibleNextState : transitionModel.getPossibleStates(state, action)) {
            expectedTotalReward += transitionModel.calculate(state, action, possibleNextState) *
                    (rewardModel.calculate(state, action, possibleNextState) + gamma * stateValueFunction.calculate(possibleNextState) );
        }

        return expectedTotalReward;
    }

}
