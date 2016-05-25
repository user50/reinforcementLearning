package policy.reinforcement.transition;

import math.Vector;
import policy.Action;
import policy.State;

import static math.VectorAlgebra.*;

public class TrivialTransitionModel implements TransitionModel {
    @Override
    public State predict(State state, Action action) {

        Vector nextSpeed = multiply(state.getMySpeed(), action.getEnginePower() / 10 + 1);
        nextSpeed = rotateVector(nextSpeed, action.getWheelTurn()/4);

        Vector nextMyLoc = sum(state.getMyPosition(), nextSpeed);

        return new State(nextMyLoc, nextSpeed, state.getNextWayTail(), state.getTick()+1);
    }
}
