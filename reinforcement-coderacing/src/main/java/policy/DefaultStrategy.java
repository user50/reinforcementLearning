package policy;

import action.CodeRacingAction;
import com.example.common.Strategy;
import state.CodeRacingState;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class DefaultStrategy implements Strategy<CodeRacingState, CodeRacingAction> {

    Policy policy;

    public DefaultStrategy(Policy policy) {
        this.policy = policy;
    }

    @Override
    public double calculate(CodeRacingState state, CodeRacingAction action) {
        throw new NotImplementedException();
    }

    @Override
    public CodeRacingAction generate(CodeRacingState state) {
        return policy.get(state);
    }

    @Override
    public void update(CodeRacingState state, CodeRacingAction action) {
        throw new NotImplementedException();
    }
}
