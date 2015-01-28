package com.example.montecarlo;

import com.example.common.Action;
import com.example.common.State;
import com.example.common.Strategy;
import com.example.common.UpdatableFunction;

/**
 * Created by user50 on 24.01.2015.
 */
public class MonteCarloStrategyIteration< S extends State,A extends Action> {

    MKFirstVisitMethod<S,A> mkFirstVisitMethod;
    StateArgumentBuilder stateArgumentBuilder;

    public Strategy<S, A> findOptimal( Strategy<S,A> strategy, UpdatableFunction<S> initFunction )
    {
        UpdatableFunction func = mkFirstVisitMethod.execute(strategy, stateArgumentBuilder);

        return null;
    }

}
