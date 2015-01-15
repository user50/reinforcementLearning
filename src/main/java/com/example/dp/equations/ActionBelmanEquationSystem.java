package com.example.dp.equations;

import com.example.common.Action;
import com.example.common.State;
import com.example.common.StateAction;
import com.example.solving.EquationSystem;

import java.util.Map;

/**
 * Created by user50 on 15.01.2015.
 */
public class ActionBelmanEquationSystem<S extends State, A extends Action> implements EquationSystem<StateAction<S, A>> {

    @Override
    public double calculate(StateAction<S, A> variable, Map<StateAction<S, A>, Double> variables) {
        return 0;
    }
}
