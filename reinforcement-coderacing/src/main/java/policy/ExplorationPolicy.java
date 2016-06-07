package policy;

import trivial.CodeRacingAction;
import com.example.common.Strategy;
import trivial.CodeRaceState;

import java.util.List;

public class ExplorationPolicy implements Strategy<CodeRaceState, CodeRacingAction> {

    Strategy<CodeRaceState, CodeRacingAction> strategy;
    List<CodeRacingAction> actions;

    public ExplorationPolicy(Strategy<CodeRaceState, CodeRacingAction> strategy, List<CodeRacingAction> actions) {
        this.strategy = strategy;
        this.actions = actions;
    }

    @Override
    public double calculate(CodeRaceState state, CodeRacingAction action) {
        return 0;
    }


    int tick = 0;
    CodeRacingAction action;
    @Override
    public CodeRacingAction generate(CodeRaceState state) {
        if (Math.random()>1) {
            tick = 10;

            action = actions.get((int) (Math.random() * actions.size()));
        }

        if (--tick>0)
        {
            return action;
        }

        return strategy.generate(state);
    }

    @Override
    public void update(CodeRaceState state, CodeRacingAction action) {

    }
}
