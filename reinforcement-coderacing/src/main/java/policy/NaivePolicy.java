package policy;

import math.Vector;
import math.VectorAlgebra;

import static math.VectorAlgebra.*;

public class NaivePolicy implements Policy {
    @Override
    public Action get(State state) {

        Vector me2target = sum(state.getNextWayTail(), multiply(state.getMyPosition(), -1));


        double wheelTurn = state.getMySpeed().getX() == 0 && state.getMySpeed().getY() == 0 ?
                0
                :
                Math.acos(scalarProd(normalise(state.getMySpeed()), normalise(me2target)));

        double wheelTurnDirection = Math.signum(vectorProd(me2target, state.getMySpeed()));

        double distance2target = VectorAlgebra.length(me2target);
        double enginePower = 0.2*Math.random() - 0.07;

        return new Action(enginePower, 2*wheelTurn * wheelTurnDirection);
    }
}
