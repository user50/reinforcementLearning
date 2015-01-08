package com.example.aima;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user50 on 07.01.2015.
 */
public class AimaStates {

    public static List<AimaState> getNonTerminalStates()
    {
        List<AimaState> nonTerminalStates = new ArrayList<AimaState>();
        nonTerminalStates.add(new AimaState(1,1));
        nonTerminalStates.add(new AimaState(1,2));
        nonTerminalStates.add(new AimaState(1,3));

        nonTerminalStates.add(new AimaState(2,1));
        nonTerminalStates.add(new AimaState(2,3));

        nonTerminalStates.add(new AimaState(3,1));
        nonTerminalStates.add(new AimaState(3,2));
        nonTerminalStates.add(new AimaState(3,3));

        nonTerminalStates.add(new AimaState(4,1));

        return nonTerminalStates;
    }
}
