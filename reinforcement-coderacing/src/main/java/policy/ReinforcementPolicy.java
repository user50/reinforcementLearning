package policy;

import trivial.CodeRaceAction;
import com.example.common.Strategy;
import trivial.CodeRaceState;

public class ReinforcementPolicy implements Policy {

    Strategy<CodeRaceState, CodeRaceAction> strategy;

    public ReinforcementPolicy(Strategy<CodeRaceState, CodeRaceAction> strategy) {
        this.strategy = strategy;
    }

    @Override
    public CodeRaceAction get(CodeRaceState state) {
        return strategy.generate(state);
    }
}
