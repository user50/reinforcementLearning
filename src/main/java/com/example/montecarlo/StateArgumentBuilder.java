package com.example.montecarlo;

import com.example.common.Action;
import com.example.common.State;
import com.example.common.StateAction;

/**
 * Created by user50 on 18.01.2015.
 */
public class StateArgumentBuilder implements ArgumentBuilder<State> {

    @Override
    public <S extends State, A extends Action> S build(Step<S, A> step) {
        return step.getState();
    }
}
