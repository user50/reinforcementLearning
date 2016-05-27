package policy;

import action.CodeRacingAction;
import com.example.common.Strategy;
import state.CodeRacingState;

public class ReinforcementPolicy implements Policy {

    Strategy<CodeRacingState, CodeRacingAction> strategy;

    public ReinforcementPolicy(Strategy<CodeRacingState, CodeRacingAction> strategy) {
        this.strategy = strategy;
    }

    @Override
    public CodeRacingAction get(CodeRacingState state) {
        return strategy.generate(state);
    }
}
