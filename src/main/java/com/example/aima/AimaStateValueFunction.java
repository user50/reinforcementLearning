package com.example.aima;

import com.example.common.UpdatableFunction;
import com.example.dp.TableUpdatableFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user50 on 06.01.2015.
 */
public class AimaStateValueFunction extends TableUpdatableFunction<AimaState> {


    public AimaStateValueFunction(Map<AimaState, Double> table) {
        super(table);
    }

    public AimaStateValueFunction() {
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
