import abstractions.CodeRaceTransitionModelStorage;
import action.Actions;
import com.example.common.table.ExponentialMeanStrategy;
import jdbc.JdbcService;
import jdbc.JdbcServiceProvider;
import trivial.*;
import action.CodeRaceTransitionModel;
import com.example.common.*;
import com.example.common.table.TableFunction;
import com.example.dp.ImproveStrategyOperation;
import com.example.montecarlo.*;
import policy.DefaultStrategy;
import policy.ExplorationPolicy;
import policy.TrainTransitionModel;
import trivial.jdbc.transition.GetTransition;
import trivial.jdbc.transition.TransitionExtractor;
import trivial.jdbc.utility.ExtractUtility;
import trivial.jdbc.utility.GetUtility;

import java.io.*;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        JdbcService jdbcService = new JdbcServiceProvider().get();
        CodeRaceTransitionModelStorage transitionModelStorage = new CodeRaceTransitionModelStorage(jdbcService);
        StoreUtility utilityStorage = new StoreUtility(jdbcService);

        Map<CodeRaceState,Double > table = jdbcService.executeQueryByCursor(new GetUtility(), new ExtractUtility());

        CodeRacingSimulator simulator = new CodeRacingSimulator(new TrivialControllerProvider());

//        TimeDifferenceMethod method = new TimeDifferenceMethod(simulator, 1, 0.999);
        MKFirstVisitMethod firstVisitMethod = new MKFirstVisitMethod<>(simulator, 1, 0.99999);

        TableFunction<CodeRaceState> tableFunction = new TableFunction<>(new ExponentialMeanStrategy<>(0.005), table);

        CodeRaceTransitionModel transitionModel = jdbcService.executeQueryByCursor(new GetTransition(), new TransitionExtractor());

        Map<CodeRaceState, CodeRaceAction> strategyTable = new HashMap<>();

        TableStrategy<CodeRaceState, CodeRaceAction> strategy = new TableStrategy<>(new DefaultStrategy(), strategyTable);

        for (int i = 0;i<100000;i++) {
            System.out.println("iteration: "+i);
            firstVisitMethod.execute(new TrainTransitionModel(new ExplorationPolicy(strategy, Actions.getActions()), transitionModel), new StateArgumentBuilder(), tableFunction);

            BestActionByStateValueFunc<CodeRaceState, CodeRaceAction> bestAction =
                    new BestActionByStateValueFunc<>(transitionModel, (a,b,c)->0.0 , new HandMadeUtility(), 1);

            Set<CodeRaceState> states = tableFunction.getTable().keySet().stream().map(state -> (CodeRaceState) state).collect(Collectors.toSet());
            new ImproveStrategyOperation<>(new ArrayList<CodeRaceState>(states), bestAction).access(strategy);

            System.out.println("possible actions count :" + new HashSet<>(strategyTable.values()).size());

            transitionModelStorage.save(transitionModel);
            utilityStorage.save(table);

        }

    }

    private static void save(List<Step<CodeRaceState, CodeRaceAction>> steps) throws FileNotFoundException {
        try(PrintWriter printWriter = new PrintWriter("output.csv"))
        {
            for (Step<CodeRaceState, CodeRaceAction> step : steps)
                printWriter.println(step.getAction().getDeltaWheelTurn()+";"+step.getAction().getDeltaWheelTurn());


        }

    }
}
