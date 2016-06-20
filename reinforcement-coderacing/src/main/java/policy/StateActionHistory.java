package policy;

import trivial.CodeRaceAction;
import trivial.CodeRaceState;

public class StateActionHistory implements Policy {

    Policy policy;


    public StateActionHistory(Policy policy) {
        this.policy = policy;
    }

    @Override
    public CodeRaceAction get(CodeRaceState state) {
        return null;
    }
}
