import state.CodeRacingStateComparator;
import com.example.common.State;
import com.example.common.UpdatableFunction;
import com.example.common.table.ExponentialMeanStrategy;
import com.example.common.table.TableFunction;
import com.example.montecarlo.MKFirstVisitMethod;
import com.example.montecarlo.StateArgumentBuilder;
import com.example.montecarlo.Step;
import action.CodeRacingAction;
import state.CodeRacingState;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        List<Step<CodeRacingState, CodeRacingAction>> steps = new CodeRacingSimulator().generateEpisode(null);

        CodeRacingSimulator aimaSimulator = new CodeRacingSimulator();

        MKFirstVisitMethod<CodeRacingState, CodeRacingAction> firstVisitMethod = new MKFirstVisitMethod<>(aimaSimulator, 10, 0.9);

        TableFunction<State> tableFunction = new TableFunction<>(new ExponentialMeanStrategy<>(0.05), new TreeMap<>(new CodeRacingStateComparator()));
        UpdatableFunction<State> function =  firstVisitMethod.execute(null, new StateArgumentBuilder(), tableFunction);

        save(steps);
    }

    private static void save(List<Step<CodeRacingState, CodeRacingAction>> steps) throws FileNotFoundException {
        try(PrintWriter printWriter = new PrintWriter("output.csv"))
        {
            for (Step<CodeRacingState, CodeRacingAction> step : steps)
                printWriter.println(step.getAction().getDeltaWheelTurn()+";"+step.getAction().getDeltaWheelTurn());


        }

    }
}
