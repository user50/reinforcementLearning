package com.example.aima.modules.dp;

import com.example.aima.*;
import com.example.dp.*;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;

/**
 * Created by user50 on 07.01.2015.
 */
public class AimaModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(new TypeLiteral<StrategyAccessor<AimaState, AimaAction>>() {});

        bind(new TypeLiteral<StrategyIteration<AimaState, AimaAction>>() {});
    }
}
