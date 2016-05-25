package policy.reinforcement.utility;

import policy.State;

public interface UtilityFunction {

    double eval(State state);
}
