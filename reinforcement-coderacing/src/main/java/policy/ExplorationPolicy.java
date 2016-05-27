package policy;

import action.CodeRacingAction;
import com.example.common.Strategy;
import state.CodeRacingState;

import java.util.List;

public class ExplorationPolicy implements Strategy<CodeRacingState, CodeRacingAction> {

    Strategy<CodeRacingState, CodeRacingAction> strategy;
    List<CodeRacingAction> actions;

    public ExplorationPolicy(Strategy<CodeRacingState, CodeRacingAction> strategy, List<CodeRacingAction> actions) {
        this.strategy = strategy;
        this.actions = actions;
    }

    @Override
    public double calculate(CodeRacingState state, CodeRacingAction action) {
        return 0;
    }

    @Override
    public CodeRacingAction generate(CodeRacingState state) {
        if (Math.random()>0.50)
            return actions.get((int)(Math.random() * actions.size()));

        return strategy.generate(state);
    }

    @Override
    public void update(CodeRacingState state, CodeRacingAction action) {

    }
}
