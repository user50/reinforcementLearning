package policy;

import trivial.CodeRacingAction;
import trivial.CodeRaceState;

public class StateActionHistory implements Policy {

    Policy policy;


    public StateActionHistory(Policy policy) {
        this.policy = policy;
    }

    @Override
    public CodeRacingAction get(CodeRaceState state) {
        return null;
    }
}
