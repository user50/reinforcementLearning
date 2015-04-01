package com.example.solving;

import java.util.Map;

/**
 * Created by user50 on 08.01.2015.
 */
public interface EquationSystem<Arg> {

    double calculate(Arg variable, Map<Arg, Double> variables);
}
