package com.example.dp;

import com.example.common.State;
import com.example.common.UpdatableFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user50 on 14.01.2015.
 */
public class TableUpdatableFunction<S> implements UpdatableFunction<S> {

    private Map<S, Double> table = new HashMap<S, Double>();

    public TableUpdatableFunction(Map<S, Double> table) {
        this.table = table;
    }

    @Override
    public double calculate(S state) {
        if (!table.containsKey(state))
            return 0;

        return table.get(state);
    }

    @Override
    public void update(S state, double value) {
        table.put( state, value);
    }
}
