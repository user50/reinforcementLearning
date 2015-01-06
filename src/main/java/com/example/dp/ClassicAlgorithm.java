package com.example.dp;

import java.util.List;

/**
 * Created by user50 on 06.01.2015.
 */
public class ClassicAlgorithm<S extends State, A extends Action> {

    List<S> states;
    StateValueFunctionAccessor<S, A> accessor;
    double errorTolerance;

    public StateValueFunction<S> access(Strategy<S, A> strategy, StateValueFunction<S> stateValueFunction)
    {
        double maxError = 0;
        do {
            for (S state : states) {
                double currentValue = stateValueFunction.calculate(state);
                double nextValue = accessor.accessTotalReward(state,strategy, stateValueFunction );
                stateValueFunction.update(state, nextValue);

                maxError = Math.max(maxError, Math.abs(currentValue - nextValue));
            }
        }while (maxError > errorTolerance);

        return stateValueFunction;
    }
}
