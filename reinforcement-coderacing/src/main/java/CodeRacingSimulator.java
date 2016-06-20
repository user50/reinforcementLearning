import abstractions.RLController;
import com.example.common.Action;
import com.example.common.State;
import com.example.common.Strategy;
import com.example.montecarlo.Simulator;
import com.example.montecarlo.Step;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;

public class CodeRacingSimulator<S extends State, A extends Action> implements Simulator<S, A> {

    Function<Strategy<S, A>, RLController<S, A>> controllerProvider;

    public CodeRacingSimulator(Function<Strategy<S, A>, RLController<S, A>> controllerProvider) {
        this.controllerProvider = controllerProvider;
    }

    @Override
    public List<Step<S, A>> generateEpisode(Strategy<S, A> strategy) {
        try {
            Process p = Runtime.getRuntime().exec("reinforcement-coderacing\\start.bat");

            Thread.sleep(2000);

            RLController<S,A> myStrategy = controllerProvider.apply(strategy);

            new Runner(new String[]{"127.0.0.1", "31001", "0000000000000000"}, myStrategy).run();

            p.destroy();

            return myStrategy.getSteps();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
