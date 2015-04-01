package aima.modules.dp;

import aima.AimaAction;
import aima.AimaState;
import aima.AimaStatesActions;
import com.example.common.StateAction;
import com.example.dp.UpdatableFunctionAccessor;
import com.example.dp.builders.ActionBelmanEquationSystemBuilder;
import com.example.dp.builders.BelmanEquationSystemBuilder;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

import javax.inject.Singleton;
import java.util.List;

/**
 * Created by user50 on 17.01.2015.
 */
public class ActionValueFunctionAccessorModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(new TypeLiteral< UpdatableFunctionAccessor<StateAction<AimaState, AimaAction>, AimaState, AimaAction>>() {});

        bind(new TypeLiteral<List<StateAction<AimaState, AimaAction>>>() {}).annotatedWith(Names.named("nonTerminalStates"))
                .toInstance(AimaStatesActions.getArguments());

        bind(new TypeLiteral<BelmanEquationSystemBuilder<StateAction<AimaState, AimaAction>, AimaState, AimaAction>>() {}).
                to(new TypeLiteral<ActionBelmanEquationSystemBuilder< AimaState, AimaAction>>() {}).in(Singleton.class);

        bind(new TypeLiteral< UpdatableFunctionAccessor<StateAction<AimaState, AimaAction>, AimaState, AimaAction>>() {});
    }
}
