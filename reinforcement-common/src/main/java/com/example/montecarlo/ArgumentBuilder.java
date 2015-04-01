package com.example.montecarlo;

import com.example.common.Action;
import com.example.common.State;

/**
 * Created by user50 on 18.01.2015.
 */
public interface ArgumentBuilder<Arg> {

    public <S extends State,A extends Action> Arg build(Step<S, A> step);
}
