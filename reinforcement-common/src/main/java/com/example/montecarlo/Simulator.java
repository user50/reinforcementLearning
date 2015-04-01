package com.example.montecarlo;


import com.example.common.Action;
import com.example.common.State;
import com.example.common.Strategy;

import java.util.List;

/**
 * Created by user50 on 31.12.2014.
 */
public interface Simulator<S extends State,A extends Action> {

    List<Step<S,A>> generateEpisode(Strategy strategy);
}
