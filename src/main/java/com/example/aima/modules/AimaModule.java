package com.example.aima.modules;

import com.example.aima.*;
import com.example.common.RewardModel;
import com.example.common.TransitionModel;
import com.example.dp.*;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

import javax.inject.Singleton;
import java.util.List;

/**
 * Created by user50 on 07.01.2015.
 */
public class AimaModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Double.class).annotatedWith(Names.named("gamma")).toInstance(0.99);
        bind(Double.class).annotatedWith(Names.named("errorTolerance")).toInstance(0.01);
        bind(new TypeLiteral<List<AimaState>>() {}).annotatedWith(Names.named("nonTerminalStates"))
                .toInstance(AimaStates.getNonTerminalStates());

        bind(new TypeLiteral<TransitionModel<AimaState, AimaAction>>() {}).
                to(AimaTransitionModel.class).in(Singleton.class);

        bind(new TypeLiteral<RewardModel<AimaState, AimaAction>>() {}).
                to(AimaRewardModel.class).in(Singleton.class);

        bind(new TypeLiteral< StateValueFunctionAccessor<AimaState, AimaAction>>() {});

        bind(new TypeLiteral<StrategyAccessor<AimaState, AimaAction>>() {});

        bind(new TypeLiteral<StrategyOptimiser<AimaState, AimaAction>>() {});




    }
}
