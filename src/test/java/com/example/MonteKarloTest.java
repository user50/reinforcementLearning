package com.example;

import com.example.aima.*;
import com.example.blackjack.*;
import com.example.common.State;
import com.example.common.StateAction;
import com.example.common.table.CumulativeStrategy;
import com.example.common.table.ExponentialMeanStrategy;
import com.example.common.table.TableFunction;
import com.example.common.UpdatableFunction;
import com.example.montecarlo.MKFirstVisitMethod;
import com.example.montecarlo.StateActionArgumentBuilder;
import com.example.montecarlo.StateArgumentBuilder;
import org.junit.Test;

/**
 * Created by user50 on 18.01.2015.
 */
public class MonteKarloTest {

    @Test
    public void testAima() throws Exception {
        AimaSimulator aimaSimulator = new AimaSimulator();

        MKFirstVisitMethod<AimaState, AimaAction> firstVisitMethod = new MKFirstVisitMethod<AimaState, AimaAction>(aimaSimulator, 1000, 0.9);

        AimaStrategy strategy = new AimaStrategy();

        UpdatableFunction<State> function =  firstVisitMethod.execute(strategy, new StateArgumentBuilder(), new TableFunction<State>(new ExponentialMeanStrategy<State>(0.05)));

        new AimaStateValueFunction(((TableFunction) function).getTable()).display();
    }

    @Test
    public void testBlackJack() throws Exception {
        BlackjackSimulator simulator = new BlackjackSimulator();

        MKFirstVisitMethod<BlackjackState, BlackjackAction> firstVisitMethod = new MKFirstVisitMethod<BlackjackState, BlackjackAction>(simulator, 100000, 1);

        BlackjackStrategy strategy = new BlackjackStrategy();
        UpdatableFunction<StateAction> function =  firstVisitMethod.execute(strategy, new StateActionArgumentBuilder(),
                new TableFunction<StateAction>(new CumulativeStrategy<StateAction>()));

    }
}
