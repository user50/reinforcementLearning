package com.example.dp.statevalue;

import com.example.common.*;

/**
 * Created by user50 on 06.01.2015.
 */
public class AccessStateByStateValueFunction<S extends State, A extends Action> {

    TransitionModel<S,A> transitionModel;
    RewardModel<S,A> rewardModel;
    Strategy<S,A> strategy;
    StateValueFunction<S> stateValueFunction;
    double gamma;

    public AccessStateByStateValueFunction(TransitionModel<S, A> transitionModel, RewardModel<S, A> rewardModel, Strategy<S, A> strategy,
                                           StateValueFunction<S> stateValueFunction, double gamma) {
        this.transitionModel = transitionModel;
        this.rewardModel = rewardModel;
        this.strategy = strategy;
        this.stateValueFunction = stateValueFunction;
        this.gamma = gamma;
    }

    public double accessTotalReward(S state, Strategy<S,A> strategy, StateValueFunction<S> stateValueFunction )
    {
        double expectedTotalReward = 0;
        for (A action : transitionModel.getPossibleActions(state))
            expectedTotalReward += strategy.calculate(state, action) * accessAction(state, action, stateValueFunction);

        return expectedTotalReward;
    }

    private double accessAction(S state, A action, StateValueFunction<S> stateValueFunction) {

        double expectedTotalReward = 0;
        for (S possibleNextState : transitionModel.getPossibleStates(state, action)) {
            expectedTotalReward += transitionModel.calculate(state, action, possibleNextState) *
                    ( rewardModel.calculate(state, action, possibleNextState) + gamma * stateValueFunction.calculate(possibleNextState) );
        }

        return expectedTotalReward;
    }
}
