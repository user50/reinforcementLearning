package com.example;

import com.example.common.Strategy;
import com.example.common.UpdatableFunction;

/**
 * Created by user50 on 02.04.2015.
 */
public class Planner {

    public void findBehavior(Strategy strategy, UpdatableFunction updatableFunction)
    {
        while (someConditions())
        {
            improveFunction(strategy, updatableFunction);
            improveStrategy(strategy, updatableFunction);
        }
    }

    private void improveFunction(Strategy strategy, UpdatableFunction updatableFunction)
    {

    }

    private void improveStrategy(Strategy strategy, UpdatableFunction updatableFunction)
    {

    }

    private boolean someConditions()
    {
        return false;
    }
}
