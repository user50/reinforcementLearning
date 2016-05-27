package action;

import com.example.common.TransitionModel;
import state.CodeRacingState;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.Serializable;
import java.util.*;

public class CodeRacingTransitionModel implements TransitionModel<CodeRacingState,CodeRacingAction>, Serializable{

    List<CodeRacingAction> actions = Actions.getActions();

    Map<Point, Integer> point2count = new HashMap<>();
    Map<Point, Set<CodeRacingState>> possibleStates = new HashMap<>();


    @Override
    public double calculate(CodeRacingState state, CodeRacingAction action, CodeRacingState nextState) {
        if (point2count.containsKey(new Point(state, action)))
            return 0;

        int visits = point2count.get(new Point(state, action));
        int positive = point2count.containsKey(new Point(state, action, nextState)) ?
                point2count.get(new Point(state, action, nextState))
                :
                0;

        return (double)positive/visits;
    }

    @Override
    public List<CodeRacingAction> getPossibleActions(CodeRacingState state) {
        return actions;
    }

    @Override
    public List<CodeRacingState> getPossibleStates(CodeRacingState state, CodeRacingAction action) {
        if (!possibleStates.containsKey(new Point(state, action)))
            return new ArrayList<>();

        return new ArrayList<>(possibleStates.get(new Point(state, action)));
    }

    public void update(CodeRacingState state, CodeRacingAction action, CodeRacingState nextState)
    {
        point2count.merge(new Point(state, action), 1, (ov,nv) -> ov + nv);
        point2count.merge(new Point(state, action, nextState), 1, (ov,nv) -> ov + nv);

        Set<CodeRacingState> states = new HashSet<>();
        states.add(nextState);
        possibleStates.merge(new Point(state, action),states , (ov, nv) -> {ov.addAll(nv); return ov;});
    }

    private static class Point implements Serializable
    {
        CodeRacingState state;
        CodeRacingAction action;
        CodeRacingState nextState;

        public Point(CodeRacingState state, CodeRacingAction action, CodeRacingState nextState) {
            this.state = state;
            this.action = action;
            this.nextState = nextState;
        }

        public Point(CodeRacingState state, CodeRacingAction action) {
            this.state = state;
            this.action = action;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (!state.equals(point.state)) return false;
            if (!action.equals(point.action)) return false;
            return !(nextState != null ? !nextState.equals(point.nextState) : point.nextState != null);

        }

        @Override
        public int hashCode() {
            int result = state.hashCode();
            result = 31 * result + action.hashCode();
            result = 31 * result + (nextState != null ? nextState.hashCode() : 0);
            return result;
        }
    }
}
