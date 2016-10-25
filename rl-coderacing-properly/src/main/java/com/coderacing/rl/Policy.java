package com.coderacing.rl;

import com.coderacing.math.Vector;
import com.coderacing.rl.action.CodeRaceAction;

import static com.coderacing.math.VectorAlgebra.difference;

public class Policy {

    public CodeRaceAction get(CodeRaceState state)
    {
        Vector me = state.getMe();
        Vector target = state.getTarget();
        Vector speed = state.getMySpeed();

        Vector me2target = difference(target, me);

        return null;
    }

}
