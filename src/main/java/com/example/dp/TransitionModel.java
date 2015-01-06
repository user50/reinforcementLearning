package com.example.dp;

import java.util.List;

/**
 * Created by user50 on 06.01.2015.
 */
public interface TransitionModel<S extends State, A extends Action> {

    double calculate(S state, A action, S nextState);

    List<A> getPossibleActions(S state);

    List<S> getPossibleStates(S state, A action);
}
