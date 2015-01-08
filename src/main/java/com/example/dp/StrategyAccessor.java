package com.example.dp;


import com.example.common.*;
import com.example.dp.statevalue.FindBestActionOperationByStateValueFunction;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import java.util.List;

/**
 * Created by user50 on 07.01.2015.
 */
public class StrategyAccessor<S extends State, A extends Action> {
    List<S> nonTerminalStates;
    TransitionModel<S,A> transitionModel;
    RewardModel<S,A> rewardModel;
    double gamma;

    @Inject
    public StrategyAccessor(@Named("nonTerminalStates") List<S> nonTerminalStates,
                            TransitionModel<S, A> transitionModel,
                            RewardModel<S, A> rewardModel,
                            @Named("gamma") double gamma) {
        this.nonTerminalStates = nonTerminalStates;
        this.transitionModel = transitionModel;
        this.rewardModel = rewardModel;
        this.gamma = gamma;
    }

    public boolean access(Strategy<S, A> strategy, StateValueFunction<S> stateValueFunction)
    {
        FindBestActionOperationByStateValueFunction<S,A> findBestActionOperation = new FindBestActionOperationByStateValueFunction<S, A>(transitionModel, rewardModel, stateValueFunction, gamma );

        boolean stable = true;
        for (S state : nonTerminalStates) {
            A currentAction = strategy.generate(state);
            A bestAction = findBestActionOperation.find(state);
            strategy.update(state, bestAction);

            if (!currentAction.equals(bestAction))
                stable = false;
        }

        return stable;
    }
}
