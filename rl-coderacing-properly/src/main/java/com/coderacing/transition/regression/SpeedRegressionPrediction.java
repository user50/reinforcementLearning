package com.coderacing.transition.regression;

import com.coderacing.math.Vector;
import com.coderacing.math.VectorAlgebra;
import com.coderacing.math.regression.Regression;
import com.coderacing.rl.CodeRaceState;
import com.coderacing.rl.action.CodeRaceAction;
import com.coderacing.transition.TransitionModel;

import java.util.Hashtable;
import java.util.Map;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.signum;

public class SpeedRegressionPrediction implements TransitionModel {

    private Regression regression;

    public SpeedRegressionPrediction(Regression regression) {
        this.regression = regression;
    }

    @Override
    public CodeRaceState apply(CodeRaceState state, CodeRaceAction action) {

        double speed = VectorAlgebra.length(state.getMySpeed());

        Map<String,Double> inputs = new Hashtable<>();
        inputs.put(Predictors.speed.name(), speed);
        inputs.put(Predictors.enginePower.name(), state.getEnginePower());

        double deltaEnginePower = signum(action.getDeltaEnginePower())*max(abs(action.getDeltaEnginePower()), 0.025);
        inputs.put(Predictors.deltaEnginePower.name(), deltaEnginePower);

        double predictedSpeed = regression.calculate(inputs);

        Vector speedVector = VectorAlgebra.multiply(state.getMySpeed(), predictedSpeed/speed);

        return new CodeRaceState(state.getMe(), state.getTarget(), speedVector, state.getWheelTurn(), state.getEnginePower());
    }
}
