package math;

import action.Actions;
import trivial.CodeRaceAction;
import com.example.common.StateAction;
import com.example.common.table.ExponentialMeanStrategy;
import com.example.common.table.TableFunction;
import org.junit.Test;
import trivial.CodeRaceState;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SomeTest {

    @Test
    public void testName() throws Exception {
        Map<StateAction,Double > table = (Map<StateAction, Double>) new ObjectInputStream(new FileInputStream("D:\\projects\\reinforcementLearning\\ActionValueFunction")).readObject();

        TableFunction<StateAction> tableFunction = new TableFunction<>(new ExponentialMeanStrategy<>(0.05), table);

        Set<CodeRaceState> states = tableFunction.getTable().keySet().stream().map(step -> (CodeRaceState) step.getState()).collect(Collectors.toSet());

        for (CodeRaceState state : states) {
            for (CodeRaceAction action : Actions.getActions()) {
                StateAction stateAction = new StateAction(state, action);
                if (table.containsKey(stateAction))
                    System.out.println(state +" : "+action+"; expected "+table.get(stateAction));



            }
        }

    }
}
