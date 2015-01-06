package com.example.dp;

/**
 * Created by user50 on 06.01.2015.
 */
public interface Strategy<S extends State,A extends Action> {

    double calculate(S state, A action);

    void update(S state, A action);

}
