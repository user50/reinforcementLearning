package com.example.dp;

import com.example.common.Action;
import com.example.common.State;
import com.example.common.Strategy;
import com.example.common.UpdatableFunction;
import com.example.dp.builders.BelmanEquationSystemBuilder;
import com.example.dp.TableUpdatableFunction;
import com.example.solving.EquationSystem;
import com.example.solving.Solver;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user50 on 14.01.2015.
 */
public class UpdatableFunctionAccessor<Arg, S extends State, A extends Action> {

    List<Arg> nonTerminalStates;
    double errorTolerance;
    BelmanEquationSystemBuilder<Arg,S,A> belmanEquationSystemBuilder;

    @Inject
    public UpdatableFunctionAccessor(@Named("nonTerminalStates")List<Arg> nonTerminalStates,
                                     @Named("errorTolerance") double errorTolerance,
                                     BelmanEquationSystemBuilder<Arg, S, A> belmanEquationSystemBuilder) {
        this.nonTerminalStates = nonTerminalStates;
        this.errorTolerance = errorTolerance;
        this.belmanEquationSystemBuilder = belmanEquationSystemBuilder;
    }

    public UpdatableFunction<Arg> access(Strategy<S, A> strategy, UpdatableFunction<Arg> function) {
        EquationSystem<Arg> system = belmanEquationSystemBuilder.build(strategy);

        Solver<Arg> solver = new Solver<Arg>(system, errorTolerance);

        Map<Arg,Double> solution = solver.solve(init(function));

        return new TableUpdatableFunction<Arg>(solution);
    }

    private Map<Arg,Double> init(UpdatableFunction<Arg> stateValueFunction)
    {
        Map<Arg,Double> init = new HashMap<Arg, Double>();
        for (Arg nonTerminalState : nonTerminalStates)
            init.put(nonTerminalState, stateValueFunction.calculate(nonTerminalState));

        return init;
    }

}
