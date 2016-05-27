package action;

import com.example.common.Action;

import java.io.Serializable;

public class CodeRacingAction implements Action, Serializable {

    DeltaWheelTurn deltaWheelTurn;
    DeltaEnginePower deltaPower;

    public CodeRacingAction(DeltaWheelTurn deltaWheelTurn, DeltaEnginePower deltaPower) {
        this.deltaWheelTurn = deltaWheelTurn;
        this.deltaPower = deltaPower;
    }

    public double getDeltaWheelTurn() {
        if (deltaWheelTurn == null)
            return 0;

        return deltaWheelTurn.getDeltaWheelTurn();
    }

    public double getDeltaEnginePower() {
        if (deltaPower == null)
            return 0;

        return deltaPower.getDeltaEnginePower();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CodeRacingAction that = (CodeRacingAction) o;

        if (deltaWheelTurn != null ? !deltaWheelTurn.equals(that.deltaWheelTurn) : that.deltaWheelTurn != null)
            return false;
        return !(deltaPower != null ? !deltaPower.equals(that.deltaPower) : that.deltaPower != null);

    }

    @Override
    public int hashCode() {
        int result = deltaWheelTurn != null ? deltaWheelTurn.hashCode() : 0;
        result = 31 * result + (deltaPower != null ? deltaPower.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "deltaWheelTurn=" + getDeltaWheelTurn() +
                ", deltaPower=" + getDeltaEnginePower() +
                '}';
    }
}
