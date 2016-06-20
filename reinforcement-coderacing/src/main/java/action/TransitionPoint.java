package action;

import trivial.CodeRaceAction;
import trivial.CodeRaceState;

public class TransitionPoint {
    private CodeRaceState state;
    private CodeRaceAction action;
    private CodeRaceState nextState;

    public TransitionPoint(CodeRaceState state, CodeRaceAction action, CodeRaceState nextState) {
        this.state = state;
        this.action = action;
        this.nextState = nextState;
    }

    public CodeRaceState getState() {
        return state;
    }

    public CodeRaceAction getAction() {
        return action;
    }

    public CodeRaceState getNextState() {
        return nextState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransitionPoint that = (TransitionPoint) o;

        if (!state.equals(that.state)) return false;
        if (!action.equals(that.action)) return false;
        return nextState.equals(that.nextState);

    }

    @Override
    public int hashCode() {
        int result = state.hashCode();
        result = 31 * result + action.hashCode();
        result = 31 * result + nextState.hashCode();
        return result;
    }
}
