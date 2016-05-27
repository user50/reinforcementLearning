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

}
