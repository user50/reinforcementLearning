import action.Actions;
import action.CodeRacingAction;
import action.CodeRacingTransitionModel;
import com.example.common.*;
import com.example.common.table.ExponentialMeanStrategy;
import com.example.common.table.TableFunction;
import com.example.dp.ImproveStrategyOperation;
import com.example.montecarlo.*;
import policy.DefaultStrategy;
import policy.ExplorationPolicy;
import policy.TrainTransitionModel;
import state.CodeRacingState;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Map<CodeRacingState,Double > table = new File("ActionValueFunction").exists() ?
                (Map<CodeRacingState, Double>) new ObjectInputStream(new FileInputStream("ActionValueFunction")).readObject()
                :
                new HashMap<>();

        CodeRacingSimulator aimaSimulator = new CodeRacingSimulator();

        MKFirstVisitMethod firstVisitMethod = new MKFirstVisitMethod<>(aimaSimulator, 1, 0.999);

        TableFunction<CodeRacingState> tableFunction = new TableFunction<>(new ExponentialMeanStrategy<>(0.1), table);

        CodeRacingTransitionModel transitionModel = new File("transitionModel").exists() ?
                (CodeRacingTransitionModel) new ObjectInputStream(new FileInputStream("transitionModel")).readObject()
                :
                new CodeRacingTransitionModel();

        Map<CodeRacingState,CodeRacingAction> strategyTable = new File("strategy").exists() ?
                (Map<CodeRacingState, CodeRacingAction>) new ObjectInputStream(new FileInputStream("strategy")).readObject()
                :
                new HashMap<>();



        TableStrategy<CodeRacingState,CodeRacingAction> strategy = new TableStrategy<>(new DefaultStrategy(), strategyTable);

        for (int i = 0;i<1000;i++) {
            System.out.println("iteration: "+i);
            firstVisitMethod.execute(new TrainTransitionModel(new ExplorationPolicy(strategy, Actions.getActions()), transitionModel), new StateArgumentBuilder(), tableFunction);

            BestActionByStateValueFunc<CodeRacingState,CodeRacingAction> bestAction =
                    new BestActionByStateValueFunc<>(transitionModel, (a,b,c)->0.0 , tableFunction, 0.999);

            Set<CodeRacingState> states = tableFunction.getTable().keySet().stream().map(state -> (CodeRacingState) state).collect(Collectors.toSet());
            new ImproveStrategyOperation<>(new ArrayList<CodeRacingState>(states), bestAction).access(strategy);

            System.out.println("possible actions count :" + new HashSet<>(strategyTable.values()).size());

            try {
                new ObjectOutputStream(new FileOutputStream("ActionValueFunction")).writeObject(tableFunction.getTable());
                new ObjectOutputStream(new FileOutputStream("transitionModel")).writeObject(transitionModel);
                new ObjectOutputStream(new FileOutputStream("strategy")).writeObject(strategyTable);
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
