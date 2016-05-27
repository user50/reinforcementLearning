package policy;

import action.CodeRacingAction;
import action.CodeRacingTransitionModel;
import com.example.common.Strategy;
import state.CodeRacingState;

public class TrainTransitionModel implements Strategy<CodeRacingState, CodeRacingAction> {

    Strategy<CodeRacingState, CodeRacingAction> strategy;
    CodeRacingTransitionModel transitionModel;

    CodeRacingState preState;
    CodeRacingAction preAction;

    public TrainTransitionModel(Strategy<CodeRacingState, CodeRacingAction> strategy, CodeRacingTransitionModel transitionModel) {
        this.strategy = strategy;
        this.transitionModel = transitionModel;
    }

    @Override
    public double calculate(CodeRacingState state, CodeRacingAction action) {
        return strategy.calculate(state, action);
    }

    @Override
    public CodeRacingAction generate(CodeRacingState state) {
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
    public void update(CodeRacingState state, CodeRacingAction action) {
        strategy.update(state, action);
    }
}
