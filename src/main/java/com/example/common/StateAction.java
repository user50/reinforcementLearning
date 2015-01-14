package com.example.common;

/**
 * Created by user50 on 14.01.2015.
 */
public class StateAction<S extends State, A extends Action> {

    private S state;
    private A action;

    public StateAction(S state, A action) {
        this.state = state;
        this.action = action;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StateAction that = (StateAction) o;

        if (!action.equals(that.action)) return false;
        if (!state.equals(that.state)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = state.hashCode();
        result = 31 * result + action.hashCode();
        return result;
    }
}
