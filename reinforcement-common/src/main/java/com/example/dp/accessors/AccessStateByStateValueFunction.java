package com.example.dp.accessors;

import com.example.common.*;

/**
 * Created by user50 on 06.01.2015.
 */
public class AccessStateByStateValueFunction<S extends State, A extends Action> {

    TransitionModel<S,A> transitionModel;
    RewardModel<S,A> rewardModel;
    Strategy<S,A> strategy;
    UpdatableFunction<S> stateValueFunction;
    double gamma;

    public AccessStateByStateValueFunction(TransitionModel<S, A> transitionModel, RewardModel<S, A> rewardModel, Strategy<S, A> strategy,
                                           UpdatableFunction<S> stateValueFunction, double gamma) {
        this.transitionModel = transitionModel;
        this.rewardModel = rewardModel;
        this.strategy = strategy;
        this.stateValueFunction = stateValueFunction;
        this.gamma = gamma;
    }

    public double accessTotalReward(S state )
    {
        AccessActionByStateValueFunction<S,A> accessAction = new AccessActionByStateValueFunction<S,A>(stateValueFunction, transitionModel, rewardModel, gamma);
        double expectedTotalReward = 0;
        for (A action : transitionModel.getPossibleActions(state))
            expectedTotalReward += strategy.calculate(state, action) * accessAction.access(state, action);

        return expectedTotalReward;
    }
}
