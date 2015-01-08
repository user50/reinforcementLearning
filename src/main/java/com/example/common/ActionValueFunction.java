package com.example.common;

/**
 * Created by user50 on 07.01.2015.
 */
public interface ActionValueFunction<S extends State, A extends Action> {

    double access(S state, A action);
}
