package com.example.aima;

import com.example.common.UpdatableFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user50 on 06.01.2015.
 */
public class AimaStateValueFunction implements UpdatableFunction<AimaState> {

    Map<AimaState, Double> table = new HashMap<AimaState, Double>();

    @Override
    public double calculate(AimaState state) {
        if (!table.containsKey(state))
            return 0;

        return table.get(state);
    }

    @Override
    public void update(AimaState state, double nextValue) {
        table.put( state, nextValue);
    }

    public void display() {

        for (int j=3; j>=1 ;j--)
        {
            for (int i = 1;i<=4; i++) {
                System.out.print(table.get(new AimaState(i, j)));
                System.out.print(";  ");
            }
            System.out.println();
        }
    }
}
