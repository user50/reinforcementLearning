package com.example.learning;

/**
 * Created by user50 on 25.12.2014.
 */
public interface Strategy {
    public int getAction();

    public void adapt(int machine, double value);
}
