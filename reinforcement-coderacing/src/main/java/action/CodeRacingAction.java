package action;

import com.example.common.Action;

import java.io.Serializable;
import java.util.Optional;

public class CodeRacingAction implements Action, Serializable {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CodeRacingAction that = (CodeRacingAction) o;

        if (!deltaWheelTurn.equals(that.deltaWheelTurn)) return false;
        return deltaPower.equals(that.deltaPower);

    }

    @Override
    public int hashCode() {
        int result = deltaWheelTurn.hashCode();
        result = 31 * result + deltaPower.hashCode();
        return result;
    }
}
