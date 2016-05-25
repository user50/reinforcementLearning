package policy.reinforcement;

import policy.Action;
import policy.Policy;
import policy.State;
import policy.reinforcement.optimization.Optimiser;
import policy.reinforcement.transition.TransitionModel;
import policy.reinforcement.utility.UtilityFunction;

public class SecondPolicy implements Policy {

    TransitionModel transitionModel;
    UtilityFunction utilityFunction;
    Optimiser optimiser;

    public SecondPolicy(TransitionModel transitionModel, UtilityFunction utilityFunction, Optimiser optimiser) {
        this.transitionModel = transitionModel;
        this.utilityFunction = utilityFunction;
        this.optimiser = optimiser;
    }


    @Override
    public Action get(State state) {

        Function<Action> function = action -> utilityFunction.eval(transitionModel.predict(state, action));

        return optimiser.findSolution(function );
    }

}
