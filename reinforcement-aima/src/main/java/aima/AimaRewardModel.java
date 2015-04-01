package aima;

import com.example.common.RewardModel;

/**
 * Created by user50 on 06.01.2015.
 */
public class AimaRewardModel implements RewardModel<AimaState, AimaAction> {
    @Override
    public double calculate(AimaState state, AimaAction action, AimaState nextState) {
        if (nextState.equals(new AimaState(4,3)))
            return 1;

        if (nextState.equals(new AimaState(4,2)))
            return -1;

        return 0;
    }
}
