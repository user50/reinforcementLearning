package policy.reinforcement.optimization;

import policy.Action;
import policy.reinforcement.Function;

public interface Optimiser {

    Action findSolution(Function<Action> function);

}
