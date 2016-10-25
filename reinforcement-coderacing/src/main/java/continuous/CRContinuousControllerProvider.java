package continuous;

import abstractions.RLController;
import com.example.common.Strategy;
import trivial.*;

import java.util.function.Function;

public class CRContinuousControllerProvider implements Function<Strategy<CRContinuousState, CodeRaceAction>, RLController<CRContinuousState, CodeRaceAction>> {
    @Override
    public RLController<CRContinuousState, CodeRaceAction> apply(Strategy<CRContinuousState, CodeRaceAction> strategy) {
        return new RLController<>(strategy, new CRContinuousStateBuilder(), new CodeRaceActionPerformer(), new CodeRaceRewardEval());
    }
}
