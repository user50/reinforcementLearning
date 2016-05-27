package com.example.montecarlo;

import com.example.common.Action;
import com.example.common.State;

import java.io.Serializable;

/**
 * Created by user50 on 02.01.2015.
 */
public class Step<S extends State,A extends Action> implements Serializable {
    S state;
    A action;
    S nextState;
    double reward;

    public Step(S state, A action, S nextState, double reward) {
        this.state = state;
        this.action = action;
        this.nextState = nextState;
        this.reward = reward;
    }

    public S getState() {
        return state;
    }

    public A getAction() {
        return action;
    }

    public S getNextState() {
        return nextState;
    }

    public double getReward() {
        return reward;
    }
}
