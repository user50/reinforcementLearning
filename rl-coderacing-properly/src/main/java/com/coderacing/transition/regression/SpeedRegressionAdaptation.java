package com.coderacing.transition.regression;

import com.coderacing.math.VectorAlgebra;
import com.coderacing.math.regression.Regression;
import com.coderacing.rl.CodeRaceState;
import com.coderacing.rl.action.CodeRaceAction;

import java.util.Hashtable;
import java.util.Map;
import java.util.function.BiConsumer;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.signum;

public class SpeedRegressionAdaptation implements BiConsumer<CodeRaceState, CodeRaceAction>{

    private Regression regression;
    private double alpha;

    private Double lastSpeed;
    private Double lastEnginePower;

    public SpeedRegressionAdaptation(Regression regression, double alpha) {
        this.regression = regression;
        this.alpha = alpha;
    }

    public void accept(CodeRaceState state, CodeRaceAction action) {
        if (lastEnginePower == null || lastSpeed == null) {
            lastEnginePower = state.getEnginePower();
            lastSpeed = VectorAlgebra.length(state.getMySpeed());

            return;
        }

        double speed = VectorAlgebra.length(state.getMySpeed());

        Map<String,Double> inputs = new Hashtable<>();
        inputs.put(Predictors.speed.name(), lastSpeed);
        inputs.put(Predictors.enginePower.name(), lastEnginePower);

        double deltaEnginePower = signum(action.getDeltaEnginePower())*max(abs(action.getDeltaEnginePower()), 0.025);
        inputs.put(Predictors.deltaEnginePower.name(), deltaEnginePower );

        regression.adapt(inputs, speed, alpha);

        lastSpeed = speed;
        lastEnginePower = state.getEnginePower();
    }

}
