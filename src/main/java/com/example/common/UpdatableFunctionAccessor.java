package com.example.common;

import com.example.common.Action;
import com.example.common.State;
import com.example.common.Strategy;
import com.example.common.UpdatableFunction;

/**
 * Created by user50 on 14.01.2015.
 */
public interface UpdatableFunctionAccessor<Arg, S extends State, A extends Action> {

    UpdatableFunction<Arg> access( Strategy<S,A> strategy, UpdatableFunction<Arg> function);

}
