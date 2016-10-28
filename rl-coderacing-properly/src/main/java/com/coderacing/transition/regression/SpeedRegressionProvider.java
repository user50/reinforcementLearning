package com.coderacing.transition.regression;

import com.coderacing.math.regression.Regression;
import com.coderacing.math.regression.Regressor;
import com.coderacing.math.regression.SimplePow;
import com.coderacing.rl.CodeRaceState;
import com.coderacing.rl.action.CodeRaceAction;
import com.coderacing.transition.AdaptiveTransitionModel;
import com.coderacing.transition.TransitionModel;
import com.coderacing.transition.regression.SpeedRegressionAdaptation;
import com.coderacing.transition.regression.SpeedRegressionPrediction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class SpeedRegressionProvider {

    public TransitionModel get()
    {
        return getSpeedRegression();
    }

    private TransitionModel getSpeedRegression()
    {
        List<Regressor> regressors = new ArrayList<>();

        regressors.add(new SimplePow(Predictors.speed.name(),1));
        regressors.add(new SimplePow(Predictors.enginePower.name(),1));
        regressors.add(new SimplePow(Predictors.deltaEnginePower.name(),1));

        Regression regression = new Regression(regressors);

        BiConsumer<CodeRaceState, CodeRaceAction> adaptation = new SpeedRegressionAdaptation(regression, 0.1);
        TransitionModel prediction = new SpeedRegressionPrediction(regression);

        return  new AdaptiveTransitionModel(adaptation, prediction);
    }

}
