package action;

import com.example.common.TransitionModel;
import trivial.CodeRaceAction;
import trivial.CodeRaceState;

import java.io.Serializable;
import java.util.*;

public class CodeRaceTransitionModel implements TransitionModel<CodeRaceState, CodeRaceAction>, Serializable{

    List<CodeRaceAction> actions = Actions.getActions();

    Map<TransitionPoint, Long> transitions = new HashMap<>();
    Map<DecisionPoint, Long> decisions = new HashMap<>();
    Map<DecisionPoint, Set<CodeRaceState>> possibleStates = new HashMap<>();

    public CodeRaceTransitionModel(Map<TransitionPoint, Long> transitions, Map<DecisionPoint, Long> decisions, Map<DecisionPoint, Set<CodeRaceState>> possibleStates) {
        this.transitions = transitions;
        this.decisions = decisions;
        this.possibleStates = possibleStates;
    }

    @Override
    public double calculate(CodeRaceState state, CodeRaceAction action, CodeRaceState nextState) {
        if (!decisions.containsKey(new DecisionPoint(state, action)))
            return 0;

        long visits = decisions.get(new DecisionPoint(state, action));
        long positive = transitions.containsKey(new TransitionPoint(state, action, nextState)) ?
                transitions.get(new TransitionPoint(state, action, nextState))
                :
                0;

        return (double)positive/visits;
    }

    @Override
    public List<CodeRaceAction> getPossibleActions(CodeRaceState state) {
        return actions;
    }

    @Override
    public List<CodeRaceState> getPossibleStates(CodeRaceState state, CodeRaceAction action) {
        if (!decisions.containsKey(new DecisionPoint(state, action)))
            return new ArrayList<>();


        return new ArrayList<>(possibleStates.get(new DecisionPoint(state, action)));
    }

    public void update(CodeRaceState state, CodeRaceAction action, CodeRaceState nextState)
    {
        decisions.merge(new DecisionPoint(state, action), 1l, (ov, nv) -> ov + nv);
        transitions.merge(new TransitionPoint(state, action, nextState), 1l, (ov, nv) -> ov + nv);

        Set<CodeRaceState> states = new HashSet<>();
        states.add(nextState);
        possibleStates.merge(new DecisionPoint(state, action),states , (ov, nv) -> {ov.addAll(nv); return ov;});
    }

    public Map<TransitionPoint, Long> getTransitions() {
        return transitions;
    }

    public Map<DecisionPoint, Long> getDecisions() {
        return decisions;
    }

    public List<CodeRaceAction> getActions() {
        return actions;
    }

    public Map<DecisionPoint, Set<CodeRaceState>> getPossibleStates() {
        return possibleStates;
    }
}
