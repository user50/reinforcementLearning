package policy;

import action.CodeRacingAction;
import action.DeltaEnginePower;
import action.DeltaEnginePowerLevel;
import action.DeltaWheelTurn;
import com.example.common.Strategy;
import state.CodeRacingState;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Optional;

public class DefaultStrategy implements Strategy<CodeRacingState, CodeRacingAction> {



    @Override
    public double calculate(CodeRacingState state, CodeRacingAction action) {
        throw new NotImplementedException();
    }

    @Override
    public CodeRacingAction generate(CodeRacingState state) {
        return new CodeRacingAction(null, new DeltaEnginePower(DeltaEnginePowerLevel.maximal, true));
    }

    @Override
    public void update(CodeRacingState state, CodeRacingAction action) {
        throw new NotImplementedException();
    }
}
