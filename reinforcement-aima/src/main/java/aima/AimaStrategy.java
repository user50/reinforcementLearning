package aima;

import com.example.common.Strategy;
import com.example.util.SoftMax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user50 on 06.01.2015.
 */
public class AimaStrategy implements Strategy<AimaState, AimaAction> {
    Map<AimaState, AimaAction> stateActionMap = new HashMap<AimaState, AimaAction>();

    @Override
    public double calculate(AimaState state, AimaAction action) {
        if (stateActionMap.containsKey(state)  )
        {
            if (stateActionMap.get(state).equals(action))
                return 1;
            else
                return 0;
        }

        return 0.25;
    }

    @Override
    public AimaAction generate(AimaState state) {
        List<Double> probabilities = new ArrayList<Double>();
        for (AimaAction aimaAction : AimaAction.values()) {
            probabilities.add(calculate(state, aimaAction));
        }

        return AimaAction.values()[SoftMax.generate(probabilities)];
    }

    @Override
    public void update(AimaState state, AimaAction action) {
        stateActionMap.put(state, action);
    }

    public void display() {

        for (int j=3; j>=1 ;j--)
        {
            for (int i = 1;i<=4; i++) {
                System.out.print(stateActionMap.get(new AimaState(i, j)));
                System.out.print(";  ");
            }
            System.out.println();
        }
    }
}
