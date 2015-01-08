package com.example;

import com.example.aima.*;
import com.example.aima.modules.AimaModule;
import com.example.dp.StrategyOptimiser;
import com.google.inject.Guice;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;

/**
 * Created by user50 on 06.01.2015.
 */
public class Test {

    @org.junit.Test
    public void testName() throws Exception {
        StrategyOptimiser<AimaState, AimaAction> optimiser = Guice.createInjector(new AimaModule())
                .getInstance(Key.get(new TypeLiteral<StrategyOptimiser<AimaState, AimaAction>>() {}));

        AimaStrategy strategy = new AimaStrategy();
        AimaStateValueFunction stateValueFunction = new AimaStateValueFunction();

        optimiser.findOptimal(strategy, stateValueFunction);

        strategy.display();

    }
}
