package com.example;

import com.example.problem.NArmedBanditProblem;
import com.example.problem.NArmedBanditProblemBuilder;
import com.example.problem.NormalRandomGenerator;

/**
 * Created by user50 on 22.12.2014.
 */
public class Main {

    public static void main(String[] args) {
        int numberOfActions = 10;

        NArmedBanditProblemBuilder builder = new NArmedBanditProblemBuilder(numberOfActions, new NormalRandomGenerator(0, 1), new NormalRandomGenerator(1, 1));
        Strategy strategy = new EGreedyStrategy(new ActionValueFunction(numberOfActions), numberOfActions, 0.1);

        new Simulator( 20000, builder.build(), strategy).simulate();

    }

}
