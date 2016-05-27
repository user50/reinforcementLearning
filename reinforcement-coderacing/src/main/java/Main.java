import action.Actions;
import action.CodeRacingAction;
import action.CodeRacingTransitionModel;
import com.example.common.*;
import com.example.common.table.ExponentialMeanStrategy;
import com.example.common.table.TableFunction;
import com.example.dp.ImproveStrategyOperation;
import com.example.montecarlo.MKFirstVisitMethod;
import com.example.montecarlo.StateActionArgumentBuilder;
import com.example.montecarlo.Step;
import policy.DefaultStrategy;
import policy.ExplorationPolicy;
import policy.TrainTransitionModel;
import state.CodeRacingState;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Map<StateAction,Double > table = new File("ActionValueFunction").exists() ?
                (Map<StateAction, Double>) new ObjectInputStream(new FileInputStream("ActionValueFunction")).readObject()
                :
                new HashMap<>();

        CodeRacingSimulator aimaSimulator = new CodeRacingSimulator();

        MKFirstVisitMethod<CodeRacingState, CodeRacingAction> firstVisitMethod = new MKFirstVisitMethod<>(aimaSimulator, 1, 0.999);

        TableFunction<StateAction> tableFunction = new TableFunction<>(new ExponentialMeanStrategy<>(0.05), table);

        CodeRacingTransitionModel transitionModel = new File("transitionModel").exists() ?
                (CodeRacingTransitionModel) new ObjectInputStream(new FileInputStream("transitionModel")).readObject()
                :
                new CodeRacingTransitionModel();


        TableStrategy<CodeRacingState,CodeRacingAction> strategy = new TableStrategy<>(new ExplorationPolicy(new DefaultStrategy(), Actions.getActions()));

        for (int i = 0;i<1000;i++) {
            UpdatableFunction<StateAction> function =  firstVisitMethod.execute(new TrainTransitionModel(strategy, transitionModel), new StateActionArgumentBuilder(), tableFunction);

            BestActionByActionValueFunc<CodeRacingState,CodeRacingAction> bestAction =  new BestActionByActionValueFunc(new CodeRacingTransitionModel(), function);

            Set<CodeRacingState> states = tableFunction.getTable().keySet().stream().map(step -> (CodeRacingState) step.getState()).collect(Collectors.toSet());
            new ImproveStrategyOperation<>(new ArrayList<CodeRacingState>(states), bestAction).access(strategy);

            try {
                new ObjectOutputStream(new FileOutputStream("ActionValueFunction")).writeObject(tableFunction.getTable());
                new ObjectOutputStream(new FileOutputStream("transitionModel")).writeObject(transitionModel);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void save(List<Step<CodeRacingState, CodeRacingAction>> steps) throws FileNotFoundException {
        try(PrintWriter printWriter = new PrintWriter("output.csv"))
        {
            for (Step<CodeRacingState, CodeRacingAction> step : steps)
                printWriter.println(step.getAction().getDeltaWheelTurn()+";"+step.getAction().getDeltaWheelTurn());


        }

    }
}
