import action.Actions;
import trivial.CodeRacingAction;
import action.CodeRacingTransitionModel;
import com.example.common.*;
import com.example.common.table.ExponentialMeanStrategy;
import com.example.common.table.TableFunction;
import com.example.dp.ImproveStrategyOperation;
import com.example.montecarlo.*;
import policy.DefaultStrategy;
import policy.ExplorationPolicy;
import policy.TrainTransitionModel;
import trivial.CodeRaceState;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Map<CodeRaceState,Double > table = new File("ActionValueFunction").exists() ?
                (Map<CodeRaceState, Double>) new ObjectInputStream(new FileInputStream("ActionValueFunction")).readObject()
                :
                new HashMap<>();

        CodeRacingSimulator aimaSimulator = new CodeRacingSimulator();

        MKFirstVisitMethod firstVisitMethod = new MKFirstVisitMethod<>(aimaSimulator, 1, 0.999);

        TableFunction<CodeRaceState> tableFunction = new TableFunction<>(new ExponentialMeanStrategy<>(0.1), table);

        CodeRacingTransitionModel transitionModel = new File("transitionModel").exists() ?
                (CodeRacingTransitionModel) new ObjectInputStream(new FileInputStream("transitionModel")).readObject()
                :
                new CodeRacingTransitionModel();

        Map<CodeRaceState,CodeRacingAction> strategyTable = new File("strategy").exists() ?
                (Map<CodeRaceState, CodeRacingAction>) new ObjectInputStream(new FileInputStream("strategy")).readObject()
                :
                new HashMap<>();



        TableStrategy<CodeRaceState,CodeRacingAction> strategy = new TableStrategy<>(new DefaultStrategy(), strategyTable);

        for (int i = 0;i<100000;i++) {
            System.out.println("iteration: "+i);
            firstVisitMethod.execute(new TrainTransitionModel(new ExplorationPolicy(strategy, Actions.getActions()), transitionModel), new StateArgumentBuilder(), tableFunction);

            BestActionByStateValueFunc<CodeRaceState,CodeRacingAction> bestAction =
                    new BestActionByStateValueFunc<>(transitionModel, (a,b,c)->0.0 , tableFunction, 1);

            Set<CodeRaceState> states = tableFunction.getTable().keySet().stream().map(state -> (CodeRaceState) state).collect(Collectors.toSet());
            new ImproveStrategyOperation<>(new ArrayList<CodeRaceState>(states), bestAction).access(strategy);

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

    private static void save(List<Step<CodeRaceState, CodeRacingAction>> steps) throws FileNotFoundException {
        try(PrintWriter printWriter = new PrintWriter("output.csv"))
        {
            for (Step<CodeRaceState, CodeRacingAction> step : steps)
                printWriter.println(step.getAction().getDeltaWheelTurn()+";"+step.getAction().getDeltaWheelTurn());


        }

    }
}
