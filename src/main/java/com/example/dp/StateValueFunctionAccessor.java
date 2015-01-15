package com.example.dp;

import com.example.common.*;
import com.example.dp.equations.StateBelmanEquationSystem;
import com.example.solving.Solver;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user50 on 06.01.2015.
 */
public class StateValueFunctionAccessor<S extends State, A extends Action> implements UpdatableFunctionAccessor<S, S, A> {

    List<S> nonTerminalStates;
    double errorTolerance;
    TransitionModel<S,A> transitionModel;
    RewardModel<S,A> rewardModel;
    double gamma;

    @Inject
    public StateValueFunctionAccessor( @Named("nonTerminalStates") List<S> nonTerminalStates,
                                       @Named("errorTolerance") double errorTolerance,
                                       TransitionModel<S, A> transitionModel,
                                       RewardModel<S, A> rewardModel,
                                       @Named("gamma") double gamma) {
        this.nonTerminalStates = nonTerminalStates;
        this.errorTolerance = errorTolerance;
        this.transitionModel = transitionModel;
        this.rewardModel = rewardModel;
        this.gamma = gamma;
    }

    public UpdatableFunction<S> access(Strategy<S, A> strategy, UpdatableFunction<S> stateValueFunction)
    {
        StateBelmanEquationSystem<S,A> system = new StateBelmanEquationSystem<S,A>(transitionModel, rewardModel, strategy, gamma);

        Solver<S> solver = new Solver<S>(system, errorTolerance);

        Map<S,Double> solution = solver.solve(init(stateValueFunction));

        return new TableUpdatableFunction<S>(solution);
    }

    private Map<S,Double> init(UpdatableFunction<S> stateValueFunction)
    {
        Map<S,Double> init = new HashMap<S, Double>();
        for (S nonTerminalState : nonTerminalStates)
            init.put(nonTerminalState, stateValueFunction.calculate(nonTerminalState));

        return init;
    }

}
