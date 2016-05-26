package action;

import com.example.common.Action;

import java.util.Optional;

public class CodeRacingAction implements Action {

    Optional<DeltaWheelTurn> deltaWheelTurn;
    Optional<DeltaEnginePower> deltaPower;

    public CodeRacingAction(Optional<DeltaWheelTurn> deltaWheelTurn, Optional<DeltaEnginePower> deltaPower) {
        this.deltaWheelTurn = deltaWheelTurn;
        this.deltaPower = deltaPower;
    }

    public double getDeltaWheelTurn() {
        if (!deltaWheelTurn.isPresent())
            return 0;

        return deltaWheelTurn.get().getDeltaWheelTurn();
    }

    public double getDeltaEnginePower() {
        if (!deltaPower.isPresent())
            return 0;

        return deltaPower.get().getDeltaEnginePower();
    }
}
