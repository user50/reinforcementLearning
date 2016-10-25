package continuous;

import com.example.common.TransitionModel;
import trivial.CodeRaceAction;

import java.util.List;

public class ContinuousTransitionModel implements TransitionModel<CRContinuousState, CodeRaceAction> {
    @Override
    public double calculate(CRContinuousState state, CodeRaceAction action, CRContinuousState nextState) {
        return 0;
    }

    @Override
    public List<CodeRaceAction> getPossibleActions(CRContinuousState state) {
        return null;
    }

    @Override
    public List<CRContinuousState> getPossibleStates(CRContinuousState state, CodeRaceAction action) {
        return null;
    }
}
