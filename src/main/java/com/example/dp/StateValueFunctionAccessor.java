package com.example.dp;

import com.example.common.*;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import java.util.List;

/**
 * Created by user50 on 06.01.2015.
 */
public class StateValueFunctionAccessor<S extends State, A extends Action> {

    List<S> nonTerminalStates;
    double errorTolerance;
    AccessStateOperationBuilder<S,A> accessStateOperationBuilder;

    @Inject
    public StateValueFunctionAccessor(@Named("nonTerminalStates") List<S> nonTerminalStates,
                                      @Named("errorTolerance") double errorTolerance,
                                      AccessStateOperationBuilder<S, A> accessStateOperationBuilder) {
        this.nonTerminalStates = nonTerminalStates;
        this.errorTolerance = errorTolerance;
        this.accessStateOperationBuilder = accessStateOperationBuilder;
    }

    public StateValueFunction<S> access(Strategy<S, A> strategy, StateValueFunction<S> stateValueFunction)
    {
        AccessState<S, A> accessor = accessStateOperationBuilder.build(strategy, stateValueFunction);

        boolean stop;

        do {
            double maxError = 0;

            for (S state : nonTerminalStates) {
                double currentValue = stateValueFunction.calculate(state);
                double nextValue = accessor.accessTotalReward( state );
                stateValueFunction.update(state, nextValue);

                maxError = Math.max(maxError, Math.abs(currentValue - nextValue));
            }

            stop = maxError < errorTolerance;
        }while (!stop);

        return stateValueFunction;
    }
}
