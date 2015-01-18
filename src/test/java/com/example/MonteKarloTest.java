package com.example;

import com.example.aima.*;
import com.example.common.State;
import com.example.common.UpdatableFunction;
import com.example.dp.TableUpdatableFunction;
import com.example.montecarlo.MKFirstVisitMethod;
import com.example.montecarlo.StateArgumentBuilder;
import org.junit.Test;

/**
 * Created by user50 on 18.01.2015.
 */
public class MonteKarloTest {

    @Test
    public void testName() throws Exception {
        AimaSimulator aimaSimulator = new AimaSimulator();

        MKFirstVisitMethod<AimaState, AimaAction> firstVisitMethod = new MKFirstVisitMethod<AimaState, AimaAction>(aimaSimulator, 1000, 0.9);

        AimaStrategy strategy = new AimaStrategy();

        UpdatableFunction<State> function =  firstVisitMethod.execute(strategy, new StateArgumentBuilder());

        new AimaStateValueFunction(((TableUpdatableFunction) function).getTable()).display();
    }
}
