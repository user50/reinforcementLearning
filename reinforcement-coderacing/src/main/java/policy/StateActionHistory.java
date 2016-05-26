package policy;

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
