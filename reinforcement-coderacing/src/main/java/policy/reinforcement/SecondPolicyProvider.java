package policy.reinforcement;

import policy.reinforcement.optimization.SimulatedAnnealingOptimizer;
import policy.reinforcement.transition.TrivialTransitionModel;
import policy.reinforcement.utility.HandMadeUtilityFnc;

public class SecondPolicyProvider {

    public SecondPolicy get()
    {
        return new SecondPolicy(new TrivialTransitionModel(), new HandMadeUtilityFnc(), new SimulatedAnnealingOptimizer());
    }
}
