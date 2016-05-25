package policy.reinforcement.transition;

import policy.Action;
import policy.State;

public interface TransitionModel {

    State predict(State state, Action action);

}
