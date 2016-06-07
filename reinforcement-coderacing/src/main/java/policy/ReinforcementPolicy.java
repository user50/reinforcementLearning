package policy;

import trivial.CodeRacingAction;
import com.example.common.Strategy;
import trivial.CodeRaceState;

public class ReinforcementPolicy implements Policy {

    Strategy<CodeRaceState, CodeRacingAction> strategy;

    public ReinforcementPolicy(Strategy<CodeRaceState, CodeRacingAction> strategy) {
        this.strategy = strategy;
    }

    @Override
    public CodeRacingAction get(CodeRaceState state) {
        return strategy.generate(state);
    }
}
