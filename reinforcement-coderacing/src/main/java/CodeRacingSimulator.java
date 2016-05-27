import action.Actions;
import com.example.montecarlo.Simulator;
import com.example.montecarlo.Step;
import action.CodeRacingAction;
import policy.ReinforcementPolicy;
import state.CodeRacingState;
import policy.ExplorationPolicy;
import policy.Policy;

import java.io.IOException;
import java.util.List;

public class CodeRacingSimulator implements Simulator<CodeRacingState, CodeRacingAction> {
    @Override
    public List<Step<CodeRacingState, CodeRacingAction>> generateEpisode(com.example.common.Strategy<CodeRacingState, CodeRacingAction> strategy) {
        try {
            Process p = Runtime.getRuntime().exec("reinforcement-coderacing\\start.bat");

            Thread.sleep(2000);

            MyStrategy myStrategy = new MyStrategy(strategy);

            new Runner(new String[]{"127.0.0.1", "31001", "0000000000000000"}, myStrategy).run();

            p.destroy();

            return myStrategy.getSteps();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
