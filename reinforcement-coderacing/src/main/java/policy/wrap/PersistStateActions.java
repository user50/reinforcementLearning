package policy.wrap;

import math.Vector;
import policy.Action;
import policy.Policy;
import policy.State;

import java.io.PrintWriter;
import java.util.Optional;

public class PersistStateActions implements Policy {

    Policy policy;
    PrintWriter printWriter;

    Optional<State> previousState = Optional.empty();
    Optional<Action> previousAction = Optional.empty();


    public PersistStateActions(Policy policy, PrintWriter printWriter) {
        this.policy = policy;
        this.printWriter = printWriter;
    }

    @Override
    public Action get(State state) {
        Action action = policy.get(state);

        if (state.getTick() < 182)
            return action;

        if (!previousState.isPresent() ) {
            previousState = Optional.of(state);
            previousAction = Optional.of(action);

            return action;
        }

        StringBuilder line = new StringBuilder();

        line.append(stringify(previousState.get().getMyPosition()));
        line.append(";");
        line.append(stringify(previousState.get().getMySpeed()));
        line.append(";");
        line.append(previousAction.get().getEnginePower()).append(";").append(previousAction.get().getWheelTurn());
        line.append(";");
        line.append(stringify(state.getMyPosition()));
        line.append(";");
        line.append(stringify(state.getMySpeed()));

        printWriter.println(line);

        previousState = Optional.of(state);
        previousAction = Optional.of(action);

        return action;
    }

    private String stringify(Vector vector)
    {
        return vector.getX()+";"+vector.getY();
    }
}
