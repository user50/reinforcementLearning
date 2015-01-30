package com.example;

import com.example.aima.*;
import com.example.aima.modules.dp.ActionValueFunctionAccessorModule;
import com.example.aima.modules.dp.AimaModule;
import com.example.aima.modules.dp.AimaProblemDefinitionModule;
import com.example.aima.modules.dp.StateValueFunctionAccessorModule;
import com.example.common.StateAction;
import com.example.common.table.ReplaceStrategy;
import com.example.common.table.TableFunction;
import com.example.common.UpdatableFunction;
import com.example.dp.StrategyIteration;
import com.example.dp.UpdatableFunctionAccessor;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;

import java.util.HashMap;

/**
 * Created by user50 on 06.01.2015.
 */
public class Test {

    @org.junit.Test
    public void testName() throws Exception {
        StrategyIteration<AimaState, AimaAction> optimiser = Guice.createInjector(new AimaModule())
                .getInstance(Key.get(new TypeLiteral<StrategyIteration<AimaState, AimaAction>>() {}));

        AimaStrategy strategy = new AimaStrategy();
        AimaStateValueFunction stateValueFunction = new AimaStateValueFunction(new ReplaceStrategy<AimaState>());

        optimiser.findOptimal(strategy, stateValueFunction);

        strategy.display();

    }

    @org.junit.Test
    public void testStateValueFunctionAccessor() throws Exception {
        Injector injector = Guice.createInjector(new AimaProblemDefinitionModule(), new StateValueFunctionAccessorModule());

        UpdatableFunctionAccessor<AimaState, AimaState, AimaAction> functionAccessor =
                injector.getInstance(Key.get(new TypeLiteral< UpdatableFunctionAccessor<AimaState, AimaState, AimaAction>>() {}));

        AimaStrategy strategy = new AimaStrategy();
        AimaStateValueFunction stateValueFunction = new AimaStateValueFunction(new ReplaceStrategy<AimaState>());

        TableFunction<AimaState> function = (TableFunction<AimaState>) functionAccessor.access(strategy, stateValueFunction);
    }

    @org.junit.Test
    public void testActionValueFunctionAccessor() throws Exception {
        Injector injector = Guice.createInjector(new AimaProblemDefinitionModule(), new ActionValueFunctionAccessorModule());

        UpdatableFunctionAccessor<StateAction<AimaState, AimaAction>, AimaState, AimaAction> functionAccessor =
                injector.getInstance(Key.get(new TypeLiteral< UpdatableFunctionAccessor<StateAction<AimaState, AimaAction>, AimaState, AimaAction>>() {}));

        AimaStrategy strategy = new AimaStrategy();
        UpdatableFunction<StateAction<AimaState, AimaAction>> stateValueFunction
                = new TableFunction<StateAction<AimaState, AimaAction>>(new HashMap<StateAction<AimaState, AimaAction>, Double>());

        TableFunction<StateAction<AimaState, AimaAction>> function =
                (TableFunction<StateAction<AimaState, AimaAction>>) functionAccessor.access(strategy, stateValueFunction);
    }
}
