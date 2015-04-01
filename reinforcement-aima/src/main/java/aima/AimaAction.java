package aima;

import com.example.common.Action;

import java.util.HashMap;
import java.util.Map;

public enum AimaAction implements Action {
    up {
        @Override
        public Map<AimaState,Double> getDistribution(AimaState state) {
            Map<AimaState,Double> distribution = new HashMap<AimaState, Double>();

            distribution.put(new AimaState(state.getX(), state.getY() + 1), 0.8);
            distribution.put(new AimaState(state.getX() + 1, state.getY() ), 0.1);
            distribution.put(new AimaState(state.getX() - 1, state.getY() ), 0.1);

            return applyRestrictions(distribution, state);
        }
    },
    left {
        @Override
        public Map<AimaState,Double> getDistribution(AimaState state) {
            Map<AimaState,Double> distribution = new HashMap<AimaState, Double>();

            distribution.put(new AimaState(state.getX() - 1, state.getY()), 0.8);
            distribution.put(new AimaState(state.getX(), state.getY() + 1), 0.1);
            distribution.put(new AimaState(state.getX(), state.getY() - 1), 0.1);

            return applyRestrictions(distribution, state);
        }
    },
    down {
        @Override
        public Map<AimaState,Double> getDistribution(AimaState state) {
            Map<AimaState,Double> distribution = new HashMap<AimaState, Double>();

            distribution.put(new AimaState(state.getX(), state.getY() - 1), 0.8);
            distribution.put(new AimaState(state.getX() + 1, state.getY()), 0.1);
            distribution.put(new AimaState(state.getX() - 1, state.getY()), 0.1);

            return applyRestrictions(distribution, state);
        }
    },
    right {
        @Override
        public Map<AimaState,Double> getDistribution(AimaState state) {
            Map<AimaState,Double> distribution = new HashMap<AimaState, Double>();

            distribution.put(new AimaState(state.getX() + 1, state.getY()), 0.8);
            distribution.put(new AimaState(state.getX(), state.getY() + 1), 0.1);
            distribution.put(new AimaState(state.getX(), state.getY() - 1), 0.1);

            return applyRestrictions(distribution, state);
        }
    };

    private static boolean check(AimaState state)

    {
        if (state.getX() == 2 && state.getY() == 2)
            return false;

        return state.getX() >= 1 && state.getX() <= 4 && state.getY() >= 1 && state.getY() <= 3;

    }

    private static Map<AimaState,Double> applyRestrictions(Map<AimaState,Double> distribution, AimaState state)
    {
        Map<AimaState, Double> restrictedDistribution = new HashMap<AimaState, Double>();

        for (Map.Entry<AimaState, Double> entry : distribution.entrySet()) {
            AimaState nextState = check(entry.getKey()) ? entry.getKey() : state;

            if (!restrictedDistribution.containsKey(nextState))
                restrictedDistribution.put(nextState, entry.getValue());
            else
                restrictedDistribution.put( nextState, restrictedDistribution.get(nextState) + entry.getValue());
        }

        return restrictedDistribution;
    }

    public abstract Map<AimaState,Double> getDistribution(AimaState state);
}