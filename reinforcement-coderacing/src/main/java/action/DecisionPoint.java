package action;

import trivial.CodeRaceAction;
import trivial.CodeRaceState;

public class DecisionPoint {
    public CodeRaceState state;
    public CodeRaceAction action;

    public DecisionPoint(CodeRaceState state, CodeRaceAction action) {
        this.state = state;
        this.action = action;
    }

    public CodeRaceState getState() {
        return state;
    }

    public CodeRaceAction getAction() {
        return action;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DecisionPoint that = (DecisionPoint) o;

        if (!state.equals(that.state)) return false;
        return action.equals(that.action);

    }

    @Override
    public int hashCode() {
        int result = state.hashCode();
        result = 31 * result + action.hashCode();
        return result;
    }
}
