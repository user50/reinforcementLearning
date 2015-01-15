package com.example.dp.equations;

import com.example.common.*;
import com.example.dp.TableUpdatableFunction;
import com.example.dp.accessors.AccessActionByActionValueFunction;
import com.example.solving.EquationSystem;

import java.util.Map;

/**
 * Created by user50 on 15.01.2015.
 */
public class ActionBelmanEquationSystem<S extends State, A extends Action> implements EquationSystem<StateAction<S, A>> {

    TransitionModel<S,A> transitionModel;
    RewardModel<S,A> rewardModel;
    Strategy<S,A> strategy;
    double gamma;

    @Override
    public double calculate(StateAction<S, A> variable, Map<StateAction<S, A>, Double> variables) {
        AccessActionByActionValueFunction<S,A> accessor =
                new AccessActionByActionValueFunction<S,A>(transitionModel, new TableUpdatableFunction<StateAction<S, A>>(variables), strategy, rewardModel, gamma );

        return accessor.access(variable.getState(), variable.getAction());
    }
}
