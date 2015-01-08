package com.example.dp.actionvalue;

import com.example.common.Action;
import com.example.common.State;
import com.example.common.StateValueFunction;
import com.example.common.Strategy;

import java.util.List;

/**
 * Created by user50 on 07.01.2015.
 */
public class ActionValueFunctionAccessor<S extends State, A extends Action> {
    List<S> nonTerminalStates;

    public StateValueFunction<S> access(Strategy<S, A> strategy, StateValueFunction<S> stateValueFunction)
    {
        for (S nonTerminalState : nonTerminalStates) {

        }
    }

}
