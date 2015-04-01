package aima;

import com.example.common.State;
import com.example.common.UpdatableFunction;
import com.example.common.table.ExponentialMeanStrategy;
import com.example.common.table.TableFunction;
import com.example.montecarlo.MKFirstVisitMethod;
import com.example.montecarlo.StateArgumentBuilder;
import org.junit.*;
import org.junit.Test;

/**
 * Created by user50 on 01.04.2015.
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
}
