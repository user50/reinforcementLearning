package com.coderacing.transition;

import com.coderacing.transition.regression.SpeedRegressionProvider;

public class TransitionModelProvider {

    public TransitionModel get(){
        return new SpeedPredictionAccuracy(new SpeedRegressionProvider().get());
    }

}
