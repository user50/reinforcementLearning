package policy;

import action.*;
import com.example.common.Strategy;
import state.CodeRacingState;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Optional;

public class DefaultStrategy implements Strategy<CodeRacingState, CodeRacingAction> {

    List<CodeRacingAction> actions = Actions.getActions();

    @Override
    public double calculate(CodeRacingState state, CodeRacingAction action) {
        throw new NotImplementedException();
    }

    @Override
    public CodeRacingAction generate(CodeRacingState state) {
        return new CodeRacingAction(null, new DeltaEnginePower(DeltaEnginePowerLevel.maximal, true));
//        return actions.get((int)(Math.random() * actions.size()));
    }

    @Override
    public void update(CodeRacingState state, CodeRacingAction action) {
        throw new NotImplementedException();
    }
}
