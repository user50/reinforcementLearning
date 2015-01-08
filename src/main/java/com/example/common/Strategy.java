package com.example.common;

/**
 * Created by user50 on 06.01.2015.
 */
public interface Strategy<S extends State,A extends Action> {

    double calculate(S state, A action);

    A generate(S state);

    void update(S state, A action);

}
