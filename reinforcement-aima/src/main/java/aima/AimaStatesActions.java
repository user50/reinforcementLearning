package aima;

import com.example.common.StateAction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user50 on 17.01.2015.
 */
public class AimaStatesActions {

    public static List<StateAction<AimaState, AimaAction>> getArguments()
    {
        List<StateAction<AimaState, AimaAction>> list = new ArrayList<StateAction<AimaState, AimaAction>>();
        for (AimaState aimaState : AimaStates.getNonTerminalStates()) {
            for (AimaAction action : AimaAction.values()) {
                list.add(new StateAction<AimaState, AimaAction>(aimaState, action));
            }
        }

        return list;
    }
}
