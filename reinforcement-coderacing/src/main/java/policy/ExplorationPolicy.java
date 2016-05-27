package policy;

import action.CodeRacingAction;
import state.CodeRacingState;

import java.util.List;

public class ExplorationPolicy implements Policy{

    Policy policy;
    List<CodeRacingAction> actions;

    public ExplorationPolicy(Policy policy, List<CodeRacingAction> actions) {
        this.policy = policy;
        this.actions = actions;
    }

    @Override
    public CodeRacingAction get(CodeRacingState state) {
        if (Math.random()>0.90)
            return actions.get((int)(Math.random() * actions.size()));

        return policy.get(state);
    }
}
