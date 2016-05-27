package action;

import java.io.Serializable;

public class DeltaWheelTurn implements Serializable {

    WheelTurnLevel level;
    boolean positiveDirection;

    public DeltaWheelTurn(WheelTurnLevel level, boolean positiveDirection) {
        this.level = level;
        this.positiveDirection = positiveDirection;
    }

    public WheelTurnLevel getLevel() {
        return level;
    }

    public boolean isPositiveDirection() {
        return positiveDirection;
    }

    public double getDeltaWheelTurn()
    {
        int sign = positiveDirection ? 1 : -1;

        return level.getValue() * sign;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeltaWheelTurn that = (DeltaWheelTurn) o;

        if (positiveDirection != that.positiveDirection) return false;
        return level == that.level;

    }

    @Override
    public int hashCode() {
        int result = level.hashCode();
        result = 31 * result + (positiveDirection ? 1 : 0);
        return result;
    }
}
