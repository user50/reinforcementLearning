package trivial;

import com.example.common.TransitionModel;

import java.util.List;

public class HandMadeCodeRaceTransitionModel implements TransitionModel<CodeRaceState,CodeRaceAction> {
    @Override
    public double calculate(CodeRaceState state, CodeRaceAction action, CodeRaceState nextState) {
        return 0;
    }

    @Override
    public List<CodeRaceAction> getPossibleActions(CodeRaceState state) {
        return null;
    }

    @Override
    public List<CodeRaceState> getPossibleStates(CodeRaceState state, CodeRaceAction action) {
        return null;
    }
}
