package policy;

import trivial.CodeRaceAction;
import com.example.common.Strategy;
import trivial.CodeRaceState;

import java.util.List;

public class ExplorationPolicy implements Strategy<CodeRaceState, CodeRaceAction> {

    Strategy<CodeRaceState, CodeRaceAction> strategy;
    List<CodeRaceAction> actions;

    public ExplorationPolicy(Strategy<CodeRaceState, CodeRaceAction> strategy, List<CodeRaceAction> actions) {
        this.strategy = strategy;
        this.actions = actions;
    }

    @Override
    public double calculate(CodeRaceState state, CodeRaceAction action) {
        return 0;
    }


    int tick = 0;
    CodeRaceAction action;
    @Override
    public CodeRaceAction generate(CodeRaceState state) {
        if (Math.random()>0.99) {
            tick = 4;

            action = actions.get((int) (Math.random() * actions.size()));
        }

        if (--tick>0)
        {
            return action;
        }

        return strategy.generate(state);
    }

    @Override
    public void update(CodeRaceState state, CodeRaceAction action) {

    }
}
