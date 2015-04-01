package com.example.dp;

import com.example.common.*;

import java.util.List;

/**
 * Created by user50 on 17.01.2015.
 */
public class ImproveStrategyOperation<S extends State, A extends Action> {

    List<S> nonTerminalStates;
    FindBestActionOperation<S,A> findBestActionOperation;

    public ImproveStrategyOperation(List<S> nonTerminalStates, FindBestActionOperation<S, A> findBestActionOperation) {
        this.nonTerminalStates = nonTerminalStates;
        this.findBestActionOperation = findBestActionOperation;
    }

    public boolean access(Strategy<S, A> strategy)
    {
        boolean stable = true;

        for (S nonTerminalState : nonTerminalStates) {
            A currentAction = strategy.generate(nonTerminalState);
            A bestAction = findBestActionOperation.find(nonTerminalState);

            strategy.update(nonTerminalState, bestAction);

            if (!currentAction.equals(bestAction))
                stable = false;
        }

        return stable;
    }
}
