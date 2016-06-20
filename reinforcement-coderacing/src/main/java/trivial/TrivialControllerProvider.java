package trivial;

import abstractions.RLController;
import com.example.common.Strategy;

import java.util.function.Function;

public class TrivialControllerProvider implements Function<Strategy<CodeRaceState, CodeRaceAction>, RLController<CodeRaceState, CodeRaceAction>> {
    @Override
    public RLController<CodeRaceState, CodeRaceAction> apply(Strategy<CodeRaceState, CodeRaceAction> strategy) {
        return new RLController<>(strategy, new CodeRacingStateBuilder(), new CodeRaceActionPerformer(), new CodeRaceRewardEval());
    }
}
