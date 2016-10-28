package com.coderacing.transition;

import com.coderacing.rl.CodeRaceState;
import com.coderacing.rl.action.CodeRaceAction;

import java.util.function.BiFunction;

public interface TransitionModel extends BiFunction<CodeRaceState,CodeRaceAction,CodeRaceState> {

}
