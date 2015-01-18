package com.example.montecarlo;

import com.example.common.Action;
import com.example.common.State;
import com.example.common.StateAction;

/**
 * Created by user50 on 18.01.2015.
 */
public class StateActionArgumentBuilder implements ArgumentBuilder<StateAction> {
    @Override
    public <S extends State, A extends Action> StateAction<S, A> build(Step<S, A> step) {
        return new StateAction<S, A>(step.getState(), step.getAction());
    }
}
