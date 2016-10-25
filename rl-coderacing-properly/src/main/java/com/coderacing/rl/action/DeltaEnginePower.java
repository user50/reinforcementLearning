package com.coderacing.rl.action;

import java.io.Serializable;

public class DeltaEnginePower implements Serializable{

    private WheelTurnLevel deltaEnginePowerLevel;
    private boolean direction;

    public DeltaEnginePower(WheelTurnLevel deltaEnginePowerLevel, boolean direction) {
        this.deltaEnginePowerLevel = deltaEnginePowerLevel;
        this.direction = direction;
    }


    public double getDeltaEnginePower()
    {
        int sign = direction? 1:-1;

        return deltaEnginePowerLevel.getValue() * sign;
    }
}
