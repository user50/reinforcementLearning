package com.example.common;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.HashMap;
import java.util.Map;

public class TableStrategy<S extends State,A extends Action> implements Strategy<S,A> {

    Map<S,A> table = new HashMap<>();
    Strategy<S,A> defaultStrategy;

    public TableStrategy(Strategy<S, A> defaultStrategy, Map<S,A> table) {
        this.defaultStrategy = defaultStrategy;
        this.table = table;
    }

    @Override
    public double calculate(S state, A action) {
        throw new NotImplementedException();
    }


    int count = 0;
    int total = 0;

    @Override
    public A generate(S state) {
        total++;
        if (!table.containsKey(state)) {
            count++;


//            System.out.println((double)count/total);

            return defaultStrategy.generate(state);
        }

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
