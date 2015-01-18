package com.example.dp.builders;

import com.example.common.*;
import com.example.solving.EquationSystem;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * Created by user50 on 17.01.2015.
 */
public abstract class BelmanEquationSystemBuilder<Arg, S extends State, A extends Action> {

    TransitionModel<S,A> transitionModel;
    RewardModel<S,A> rewardModel;
    double gamma;

    @Inject
    protected BelmanEquationSystemBuilder(TransitionModel<S, A> transitionModel, RewardModel<S, A> rewardModel, @Named("gamma") double gamma) {
        this.transitionModel = transitionModel;
        this.rewardModel = rewardModel;
        this.gamma = gamma;
    }

    public abstract EquationSystem<Arg> build(Strategy<S, A> strategy);
}
