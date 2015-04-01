package com.example.dp.builders;

import com.example.common.*;
import com.example.dp.builders.BelmanEquationSystemBuilder;
import com.example.dp.equations.StateBelmanEquationSystem;
import com.example.solving.EquationSystem;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * Created by user50 on 17.01.2015.
 */
public class StateBelmanEquationSystemBuilder<S extends State, A extends Action> extends BelmanEquationSystemBuilder<S,S,A> {

    @Inject
    protected StateBelmanEquationSystemBuilder(TransitionModel<S, A> transitionModel, RewardModel<S, A> rewardModel, @Named("gamma") double gamma) {
        super(transitionModel, rewardModel, gamma);
    }

    @Override
    public EquationSystem<S> build(Strategy<S, A> strategy) {
        return new StateBelmanEquationSystem<S,A>( transitionModel, rewardModel, strategy, gamma );
    }
}
