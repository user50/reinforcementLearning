package blackjack;

import com.example.common.StateAction;
import com.example.common.UpdatableFunction;
import com.example.common.table.CumulativeStrategy;
import com.example.common.table.TableFunction;
import com.example.montecarlo.MKFirstVisitMethod;
import com.example.montecarlo.StateActionArgumentBuilder;
import org.junit.Test;

/**
 * Created by user50 on 18.01.2015.
 */
public class MonteKarloTest {



    @Test
    public void testBlackJack() throws Exception {
        BlackjackSimulator simulator = new BlackjackSimulator();

        MKFirstVisitMethod<BlackjackState, BlackjackAction> firstVisitMethod = new MKFirstVisitMethod<BlackjackState, BlackjackAction>(simulator, 100000, 1);

        BlackjackStrategy strategy = new BlackjackStrategy();
        UpdatableFunction<StateAction> function =  firstVisitMethod.execute(strategy, new StateActionArgumentBuilder(),
                new TableFunction<StateAction>(new CumulativeStrategy<StateAction>()));

    }
}
