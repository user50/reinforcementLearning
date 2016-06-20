package trivial;

import com.example.common.UpdatableFunction;

public class HandMadeUtility implements UpdatableFunction<CodeRaceState> {
    @Override
    public double calculate(CodeRaceState argument) {
        int wheelTurn = argument.getWheelTurn();
        int targetDirection = argument.getTargetDirection();

        int value =  3 * (Math.abs(targetDirection ));

        return 1/(1 + Math.pow(value, 3));
    }

    @Override
    public void update(CodeRaceState codeRaceState, double value) {

    }
}
