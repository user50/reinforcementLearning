package com.example.common;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.HashMap;
import java.util.Map;

public class TableStrategy<S extends State,A extends Action> implements Strategy<S,A> {

    Map<S,A> table = new HashMap<>();
    Strategy<S,A> defaultStrategy;

    public TableStrategy(Strategy<S, A> defaultStrategy) {
        this.defaultStrategy = defaultStrategy;
    }

    @Override
    public double calculate(S state, A action) {
        throw new NotImplementedException();
    }

    @Override
    public A generate(S state) {
        if (!table.containsKey(state))
            return defaultStrategy.generate(state);

        return table.get(state);
    }

    @Override
    public void update(S state, A action) {
        table.put(state, action);
    }

    public Map<S, A> getTable() {
        return table;
    }
}
