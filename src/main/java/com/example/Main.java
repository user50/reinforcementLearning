package com.example;

import com.example.problem.NArmedBanditProblem;
import com.example.problem.NArmedBanditProblemBuilder;
import com.example.problem.NormalRandomGenerator;

/**
 * Created by user50 on 22.12.2014.
 */
public class Main {

    public static void main(String[] args) {
        NArmedBanditProblemBuilder builder = new NArmedBanditProblemBuilder(10, new NormalRandomGenerator(0, 1), new NormalRandomGenerator(1, 1));

        new Simulator(10, 2000, 0.1, builder.build()).simulate();

    }

}
