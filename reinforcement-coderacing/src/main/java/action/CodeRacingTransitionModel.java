package action;

import com.example.common.TransitionModel;
import state.CodeRacingState;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class CodeRacingTransitionModel implements TransitionModel<CodeRacingState,CodeRacingAction> {

    List<CodeRacingAction> actions = Actions.getActions();

    @Override
    public double calculate(CodeRacingState state, CodeRacingAction action, CodeRacingState nextState) {
        throw new NotImplementedException();
    }

    @Override
    public List<CodeRacingAction> getPossibleActions(CodeRacingState state) {
        return actions;
    }

    @Override
    public List<CodeRacingState> getPossibleStates(CodeRacingState state, CodeRacingAction action) {
        throw new NotImplementedException();
    }
}
