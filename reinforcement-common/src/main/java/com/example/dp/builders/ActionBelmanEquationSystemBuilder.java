package com.example.dp.builders;

import com.example.common.*;
import com.example.dp.equations.ActionBelmanEquationSystem;
import com.example.solving.EquationSystem;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * Created by user50 on 17.01.2015.
 */
public class ActionBelmanEquationSystemBuilder<S extends State, A extends Action> extends BelmanEquationSystemBuilder<StateAction<S,A>,S ,A > {

    @Inject
    protected ActionBelmanEquationSystemBuilder(TransitionModel<S, A> transitionModel, RewardModel<S, A> rewardModel, @Named("gamma") double gamma) {
        super(transitionModel, rewardModel, gamma);
    }

    @Override
    public EquationSystem<StateAction<S, A>> build(Strategy<S, A> strategy) {

        return new ActionBelmanEquationSystem<S,A>(transitionModel, rewardModel, strategy, gamma);
    }
}
