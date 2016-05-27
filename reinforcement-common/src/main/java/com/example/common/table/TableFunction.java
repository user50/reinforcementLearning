package com.example.common.table;

import com.example.common.UpdatableFunction;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user50 on 14.01.2015.
 */
public class TableFunction<Arg> implements UpdatableFunction<Arg>, Serializable {

    protected Map<Arg, Double> table = new HashMap<Arg, Double>();

    UpdateTableStrategy<Arg> updateStrategy;

    public TableFunction(UpdateTableStrategy<Arg> updateStrategy) {
        this.updateStrategy = updateStrategy;
    }

    public TableFunction(UpdateTableStrategy<Arg> updateStrategy, Map<Arg, Double> table) {
        this.updateStrategy = updateStrategy;
        this.table = table;
    }

    public TableFunction(Map<Arg, Double> table) {
        this.table = table;
    }

    @Override
    public double calculate(Arg argument) {
        if (!table.containsKey(argument))
            return 0;

        return table.get(argument);
    }

    public Map<Arg, Double> getTable() {
        return table;
    }

    @Override
    public void update(Arg argument, double value) {
        updateStrategy.update(table, argument, value);
    }


}
