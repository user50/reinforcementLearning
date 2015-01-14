package com.example.dp;

import com.example.common.*;
import com.google.inject.Inject;

import javax.inject.Named;

/**
 * Created by user50 on 08.01.2015.
 */
public class AccessStateOperationBuilder<S extends State, A extends Action> {
    TransitionModel<S,A> transitionModel;
    RewardModel<S,A> rewardModel;
    double gamma;

    @Inject
    public AccessStateOperationBuilder(TransitionModel<S, A> transitionModel,
                                       RewardModel<S, A> rewardModel,
                                       @Named("gamma") double gamma) {
        this.transitionModel = transitionModel;
        this.rewardModel = rewardModel;
        this.gamma = gamma;
    }

    public AccessState<S, A> build(Strategy<S, A> strategy, UpdatableFunction<S> stateValueFunction)
    {
        return new AccessState<S, A>(transitionModel, rewardModel, strategy, stateValueFunction, gamma);
    }
}
