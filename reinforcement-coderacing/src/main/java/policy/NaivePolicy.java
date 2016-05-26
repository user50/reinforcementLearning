package policy;

import action.*;
import state.CodeRacingState;

import java.util.Optional;

public class NaivePolicy implements Policy {
    @Override
    public CodeRacingAction get(CodeRacingState state) {
        return new CodeRacingAction(getDeltaWheelTurn(state), getDeltaEnginePower(state));
    }

    private Optional<DeltaWheelTurn> getDeltaWheelTurn(CodeRacingState state)
    {
        double deltaWheelTurn =  3 * Math.acos(state.getSpeedDirection().getX()) * Math.signum(state.getSpeedDirection().getY())/2 - state.getWheelTurn();
        boolean direction = Math.signum(deltaWheelTurn)> 0;

        if (Math.abs(deltaWheelTurn) < WheelTurnLevel.low.getValue())
            return Optional.empty();

        if (Math.abs(deltaWheelTurn) < WheelTurnLevel.medium.getValue())
            return Optional.of(new DeltaWheelTurn(WheelTurnLevel.low, direction));

        if (Math.abs(deltaWheelTurn) < WheelTurnLevel.high.getValue())
            return Optional.of(new DeltaWheelTurn(WheelTurnLevel.medium, direction) );

        if (Math.abs(deltaWheelTurn) < WheelTurnLevel.maximal.getValue())
            return Optional.of(new DeltaWheelTurn(WheelTurnLevel.high, direction) );

        return Optional.of(new DeltaWheelTurn(WheelTurnLevel.maximal, direction) );
    }

    private Optional<DeltaEnginePower> getDeltaEnginePower(CodeRacingState state)
    {
        double deltaEnginePower = state.getTargetDistance() < 600 ?
                0.1 - state.getEnginePower()
                :
                0.5 - state.getEnginePower();

        if (Math.abs(deltaEnginePower) < DeltaEnginePowerLevel.maximal.getValue())
            return Optional.empty();

        return Optional.of(new DeltaEnginePower(DeltaEnginePowerLevel.maximal, Math.signum(deltaEnginePower)>0 ));
    }
}
