package policy;

import trivial.CodeRaceAction;
import action.CodeRaceTransitionModel;
import com.example.common.Strategy;
import trivial.CodeRaceState;

public class TrainTransitionModel implements Strategy<CodeRaceState, CodeRaceAction> {

    Strategy<CodeRaceState, CodeRaceAction> strategy;
    CodeRaceTransitionModel transitionModel;

    CodeRaceState preState;
    CodeRaceAction preAction;

    public TrainTransitionModel(Strategy<CodeRaceState, CodeRaceAction> strategy, CodeRaceTransitionModel transitionModel) {
        this.strategy = strategy;
        this.transitionModel = transitionModel;
    }

    @Override
    public double calculate(CodeRaceState state, CodeRaceAction action) {
        return strategy.calculate(state, action);
    }

    @Override
    public CodeRaceAction generate(CodeRaceState state) {
        if (preState != null)
        {
            transitionModel.update(preState, preAction, state);
        }

        CodeRaceAction action = strategy.generate(state);

        preState = state;
        preAction = action;

        return action;
    }

    @Override
    public void update(CodeRaceState state, CodeRaceAction action) {
        strategy.update(state, action);
    }
}
