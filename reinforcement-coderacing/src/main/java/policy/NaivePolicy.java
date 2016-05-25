package policy;

import math.Vector;
import math.VectorAlgebra;

import static math.VectorAlgebra.*;

public class NaivePolicy implements Policy {
    @Override
    public Action get(State state) {
        double enginePower = state.getTargetDistance() < 600 ? 0.1 : 0.5;
        double wheelTurn = state.getSpeedDirection().getX() * Math.signum(state.getSpeedDirection().getY())/2;

        return new Action(enginePower, wheelTurn);
    }
}
