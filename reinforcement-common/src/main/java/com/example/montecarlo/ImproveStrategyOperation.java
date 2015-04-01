package com.example.montecarlo;

import com.example.common.Action;
import com.example.common.BestActionByActionValueFunc;
import com.example.common.State;
import com.example.common.Strategy;
import com.example.dp.FindBestActionOperation;

import java.util.List;

/**
 * Created by user50 on 05.03.2015.
 */
public class ImproveStrategyOperation<S extends State, A extends Action> {

    FindBestActionOperation<S,A> findBestAction;
    List<S> states;

    public ImproveStrategyOperation(BestActionByActionValueFunc<S, A> findBestAction, List<S> states) {
        this.findBestAction = findBestAction;
        this.states = states;
    }

    public void improve(Strategy<S, A> strategy)
    {
        for (S state : states)
            strategy.update(state, findBestAction.find(state));

    }

}
