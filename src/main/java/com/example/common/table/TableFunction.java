package com.example.common.table;

import com.example.common.State;
import com.example.common.UpdatableFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user50 on 14.01.2015.
 */
public class TableFunction<S> implements UpdatableFunction<S> {

    protected Map<S, Double> table = new HashMap<S, Double>();

    public TableFunction() {
    }

    public TableFunction(Map<S, Double> table) {
        this.table = table;
    }

    @Override
    public double calculate(S state) {
        if (!table.containsKey(state))
            return 0;

        return table.get(state);
    }

    public Map<S, Double> getTable() {
        return table;
    }

    @Override
    public void update(S state, double value) {
        table.put( state, value);
    }
}
