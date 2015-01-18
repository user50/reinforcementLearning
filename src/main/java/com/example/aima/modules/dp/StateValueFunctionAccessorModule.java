package com.example.aima.modules.dp;

import com.example.aima.AimaAction;
import com.example.aima.AimaState;
import com.example.aima.AimaStates;
import com.example.dp.UpdatableFunctionAccessor;
import com.example.dp.builders.BelmanEquationSystemBuilder;
import com.example.dp.builders.StateBelmanEquationSystemBuilder;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

import javax.inject.Singleton;
import java.util.List;

/**
 * Created by user50 on 17.01.2015.
 */
public class StateValueFunctionAccessorModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(new TypeLiteral< UpdatableFunctionAccessor<AimaState, AimaState, AimaAction>>() {});

        bind(new TypeLiteral<List<AimaState>>() {}).annotatedWith(Names.named("nonTerminalStates"))
                .toInstance(AimaStates.getNonTerminalStates());

        bind(new TypeLiteral<BelmanEquationSystemBuilder<AimaState, AimaState, AimaAction>>() {}).
                to(new TypeLiteral<StateBelmanEquationSystemBuilder< AimaState, AimaAction>>() {}).in(Singleton.class);

        bind(new TypeLiteral< UpdatableFunctionAccessor<AimaState, AimaState, AimaAction>>() {});
    }
}
