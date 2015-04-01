package com.example.common.table;

import java.util.Map;

/**
 * Created by user50 on 29.01.2015.
 */
public interface UpdateTableStrategy<S> {

    public void update(Map<S, Double> table, S state, double value);

}
