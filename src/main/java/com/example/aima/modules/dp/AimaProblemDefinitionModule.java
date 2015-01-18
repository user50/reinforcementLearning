package com.example.aima.modules.dp;

import com.example.aima.*;
import com.example.common.RewardModel;
import com.example.common.TransitionModel;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

import javax.inject.Singleton;
import java.util.List;

/**
 * Created by user50 on 17.01.2015.
 */
public class AimaProblemDefinitionModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Double.class).annotatedWith(Names.named("gamma")).toInstance(0.99);
        bind(Double.class).annotatedWith(Names.named("errorTolerance")).toInstance(0.01);

        bind(new TypeLiteral<TransitionModel<AimaState, AimaAction>>() {}).
                to(AimaTransitionModel.class).in(Singleton.class);

        bind(new TypeLiteral<RewardModel<AimaState, AimaAction>>() {}).
                to(AimaRewardModel.class).in(Singleton.class);
    }
}
