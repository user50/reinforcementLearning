package com.coderacing.transition;

import com.coderacing.math.Vector;
import com.coderacing.math.VectorAlgebra;
import com.coderacing.rl.CodeRaceState;
import com.coderacing.rl.action.CodeRaceAction;

public class SpeedPredictionAccuracy implements TransitionModel {

    private TransitionModel model;

    private Double lastSpeedValue;
    private double sko;

    public SpeedPredictionAccuracy(TransitionModel model) {
        this.model = model;
    }

    @Override
    public CodeRaceState apply(CodeRaceState codeRaceState, CodeRaceAction action) {
        if (lastSpeedValue == null)
            lastSpeedValue = VectorAlgebra.length(codeRaceState.getMySpeed());

        CodeRaceState predictedState = model.apply(codeRaceState, action);
        Vector predicted = predictedState.getMySpeed();

        double predictedValue = VectorAlgebra.length(predicted);
        double realValue = VectorAlgebra.length(codeRaceState.getMySpeed());

        sko = sko + 0.05 * ( Math.pow(realValue - predictedValue, 2) - sko );

        System.out.println(Math.sqrt(sko)/realValue*100);

        lastSpeedValue = VectorAlgebra.length(codeRaceState.getMySpeed());

        return predictedState;
    }
}
