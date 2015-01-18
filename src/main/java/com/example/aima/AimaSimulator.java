package com.example.aima;

import com.example.common.Strategy;
import com.example.montecarlo.Simulator;
import com.example.montecarlo.Step;
import com.example.util.SoftMax;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by user50 on 31.12.2014.
 */
public class AimaSimulator implements Simulator {

    @Override
    public List<Step> generateEpisode(Strategy strategy) {
        boolean terminal = false;
        AimaState state = initState();

        List<Step> pairs = new ArrayList<Step>();
        while (!terminal) {
            AimaAction action = (AimaAction) strategy.generate(state);
            AimaState nextState = generate(state, action);

            double reward = 0;

            if (nextState.equals(new AimaState(4,2))) {
                reward = -1;
                terminal = true;
            }
            else if (nextState.equals(new AimaState(4,3))) {
                reward = 1;
                terminal = true;
            }

            pairs.add(new Step(state, action, nextState, reward));

            state = nextState;
        }

        return pairs;
    }

    public AimaState generate(AimaState state, AimaAction action)
    {
        Map<AimaState,Double> distribution = action.getDistribution(state);

        return SoftMax.generate(distribution);
    }

    private AimaState initState()
    {
        return new AimaState(1, 1);
    }
}
