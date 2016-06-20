package trivial;

import com.example.common.Action;

import java.io.Serializable;

public class CodeRaceAction implements Action, Serializable {

    private double deltaWheelTurn;

    public CodeRaceAction(double deltaWheelTurn) {
        this.deltaWheelTurn = deltaWheelTurn;
    }

    public double getDeltaWheelTurn() {
        return deltaWheelTurn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CodeRaceAction action = (CodeRaceAction) o;

        return Double.compare(action.deltaWheelTurn, deltaWheelTurn) == 0;

    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(deltaWheelTurn);
        return (int) (temp ^ (temp >>> 32));
    }
}
