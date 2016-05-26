package policy;

import action.CodeRacingAction;
import state.CodeRacingState;

public class StateActionHistory implements Policy {

    Policy policy;


    public StateActionHistory(Policy policy) {
        this.policy = policy;
    }

    @Override
    public CodeRacingAction get(CodeRacingState state) {
        return null;
    }
}
