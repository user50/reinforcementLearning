package com.coderacing.transition.hand;

import com.coderacing.rl.CodeRaceState;
import com.coderacing.rl.action.CodeRaceAction;
import com.coderacing.transition.TransitionModel;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.signum;

public class HandMadeTransitionModel implements TransitionModel {
    @Override
    public CodeRaceState apply(CodeRaceState codeRaceState, CodeRaceAction action) {

        double enginePower = codeRaceState.getEnginePower() + signum(action.getDeltaEnginePower())*max(abs(action.getDeltaEnginePower()), 0.025);
        double wheelTurn = codeRaceState.getWheelTurn() + signum(action.getDeltaWheelTurn())*max(abs(action.getDeltaWheelTurn()), 0.05);

        return null;
    }
}
