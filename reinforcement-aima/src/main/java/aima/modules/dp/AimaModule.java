package aima.modules.dp;

import aima.AimaAction;
import aima.AimaState;
import com.example.dp.StrategyAccessor;
import com.example.dp.StrategyIteration;
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
