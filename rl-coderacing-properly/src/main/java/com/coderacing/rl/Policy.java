package com.coderacing.rl;

import com.coderacing.math.Vector;
import com.coderacing.math.VectorAlgebra;
import com.coderacing.rl.action.CodeRaceAction;
import com.coderacing.rl.action.ContinuousCodeRaceAction;

import static com.coderacing.math.VectorAlgebra.difference;

public class Policy {

    public CodeRaceAction get(CodeRaceState state)
    {
        Vector me = state.getMe();
        Vector target = state.getTarget();
        Vector speed = state.getMySpeed();

        Vector me2target = difference(target, me);

        double angle = VectorAlgebra.angle(speed, me2target);
        double deltaWheel = - angle - state.getWheelTurn();

        double engine = Math.random() * 0.2;

        if (VectorAlgebra.length(me2target) < 1200)
            return new ContinuousCodeRaceAction(deltaWheel , engine - state.getEnginePower());


        return new ContinuousCodeRaceAction(deltaWheel , engine - state.getEnginePower() );
    }

}
