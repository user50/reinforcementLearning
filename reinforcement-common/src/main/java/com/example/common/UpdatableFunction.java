package com.example.common;

/**
 * Created by user50 on 06.01.2015.
 */
public interface UpdatableFunction<Arg>  {

    double calculate(Arg argument);

    void update(Arg arg, double value);
}
