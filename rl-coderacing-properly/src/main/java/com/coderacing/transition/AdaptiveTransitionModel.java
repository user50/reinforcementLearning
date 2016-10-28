package com.coderacing.transition;

import com.coderacing.math.VectorAlgebra;
import com.coderacing.rl.CodeRaceState;
import com.coderacing.rl.action.CodeRaceAction;

import java.util.function.BiConsumer;

public class AdaptiveTransitionModel implements TransitionModel{

    private BiConsumer<CodeRaceState,CodeRaceAction> modelAdapter;
    private TransitionModel model;

    private boolean started;

    public AdaptiveTransitionModel(BiConsumer<CodeRaceState, CodeRaceAction> modelAdapter, TransitionModel model) {
        this.modelAdapter = modelAdapter;
        this.model = model;
    }

    @Override
    public CodeRaceState apply(CodeRaceState codeRaceState, CodeRaceAction action) {
        if (!started)
            started = VectorAlgebra.length(codeRaceState.getMySpeed()) > 0;

        if (!started)
            return codeRaceState;

        modelAdapter.accept(codeRaceState, action);

        return model.apply(codeRaceState, action);
    }
}
