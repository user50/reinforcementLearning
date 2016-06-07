package policy;

import action.*;
import com.example.common.Strategy;
import trivial.CodeRacingAction;
import trivial.CodeRaceState;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class DefaultStrategy implements Strategy<CodeRaceState, CodeRacingAction> {

    List<CodeRacingAction> actions = Actions.getActions();

    @Override
    public double calculate(CodeRaceState state, CodeRacingAction action) {
        throw new NotImplementedException();
    }

    @Override
    public CodeRacingAction generate(CodeRaceState state) {
        return new CodeRacingAction(null, new DeltaEnginePower(DeltaEnginePowerLevel.maximal, true));
//        return actions.get((int)(Math.random() * actions.size()));
    }

    @Override
    public void update(CodeRaceState state, CodeRacingAction action) {
        throw new NotImplementedException();
    }
}
