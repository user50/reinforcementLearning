package com.example.common.table;

import java.util.Map;

/**
 * Created by user50 on 29.01.2015.
 */
public class ReplaceStrategy<Arg> implements UpdateTableStrategy<Arg>{
    @Override
    public void update(Map<Arg, Double> table, Arg argument, double value) {
        table.put(argument, value);
    }
}
