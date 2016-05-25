package policy.reinforcement.utility;

import math.Vector;
import policy.State;

import static math.VectorAlgebra.*;

public class HandMadeUtilityFnc implements UtilityFunction {
    @Override
    public double eval(State state) {
        Vector me2target = sum(state.getNextWayTail(), multiply(state.getMyPosition(), -1));

        double energy = 0;

        double speed = length(state.getMySpeed());

        if (speed > 10)
            energy += speed * 10000;

        energy += length(me2target);

        return energy;
    }
}
