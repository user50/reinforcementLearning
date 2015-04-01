package aima;

import com.example.common.TransitionModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by user50 on 06.01.2015.
 */
public class AimaTransitionModel implements TransitionModel<AimaState, AimaAction> {

    @Override
    public double calculate(AimaState state, AimaAction action, AimaState nextState) {
        Map<AimaState,Double> distribution = ( action).getDistribution( state );

        if (distribution.containsKey(nextState))
            return distribution.get(nextState);

        return 0;
    }

    @Override
    public List<AimaAction> getPossibleActions(AimaState state) {
        return Arrays.asList(AimaAction.values());
    }

    @Override
    public List<AimaState> getPossibleStates(AimaState state, AimaAction action) {
        return new ArrayList<AimaState>(action.getDistribution(state).keySet());
    }
}
