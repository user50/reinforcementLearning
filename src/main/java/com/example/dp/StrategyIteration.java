package com.example.dp;

import com.example.common.Action;
import com.example.common.State;
import com.example.common.UpdatableFunction;
import com.example.common.Strategy;
import com.google.inject.Inject;

/**
 * Created by user50 on 07.01.2015.
 */
public class StrategyIteration<S extends State, A extends Action> {

    private UpdatableFunctionAccessor<S,S,A> stateValueFunctionAccessor;
    private StrategyAccessor<S,A> strategyAccessor;

    @Inject
    public StrategyIteration(UpdatableFunctionAccessor<S, S, A> stateValueFunctionAccessor,
                             StrategyAccessor<S, A> strategyAccessor) {
        this.stateValueFunctionAccessor = stateValueFunctionAccessor;
        this.strategyAccessor = strategyAccessor;
    }

    public Strategy<S, A> findOptimal( Strategy<S,A> strategy, UpdatableFunction<S> initFunction )
    {
        UpdatableFunction<S> stateValueFunction = initFunction;

        boolean stable = false;
        while (!stable)
        {
            stateValueFunction = stateValueFunctionAccessor.access(strategy, stateValueFunction);
            stable = strategyAccessor.access(strategy, stateValueFunction);
        }

        return strategy;
    }

}
