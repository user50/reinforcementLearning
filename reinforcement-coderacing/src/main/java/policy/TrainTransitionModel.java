package policy;

import trivial.CodeRacingAction;
import action.CodeRacingTransitionModel;
import com.example.common.Strategy;
import trivial.CodeRaceState;

public class TrainTransitionModel implements Strategy<CodeRaceState, CodeRacingAction> {

    Strategy<CodeRaceState, CodeRacingAction> strategy;
    CodeRacingTransitionModel transitionModel;

    CodeRaceState preState;
    CodeRacingAction preAction;

    public TrainTransitionModel(Strategy<CodeRaceState, CodeRacingAction> strategy, CodeRacingTransitionModel transitionModel) {
        this.strategy = strategy;
        this.transitionModel = transitionModel;
    }

    @Override
    public double calculate(CodeRaceState state, CodeRacingAction action) {
        return strategy.calculate(state, action);
    }

    @Override
    public CodeRacingAction generate(CodeRaceState state) {
        if (preState != null)
        {
            transitionModel.update(preState, preAction, state);
        }

        CodeRacingAction action = strategy.generate(state);

        preState = state;
        preAction = action;

        return action;
    }

    @Override
    public void update(CodeRaceState state, CodeRacingAction action) {
        strategy.update(state, action);
    }
}
