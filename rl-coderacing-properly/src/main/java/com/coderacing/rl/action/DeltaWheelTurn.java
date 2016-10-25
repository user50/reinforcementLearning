package com.coderacing.rl.action;

import java.io.Serializable;

public class DeltaWheelTurn implements Serializable {

    private WheelTurnLevel level;
    private boolean positiveDirection;

    public DeltaWheelTurn(WheelTurnLevel level, boolean positiveDirection) {
        this.level = level;
        this.positiveDirection = positiveDirection;
    }

    public double getDeltaWheelTurn()
    {
        int sign = positiveDirection ? 1 : -1;

        return level.getValue() * sign;
    }
}
