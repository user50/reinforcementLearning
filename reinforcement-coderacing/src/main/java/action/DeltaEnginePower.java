package action;

import java.io.Serializable;

public class DeltaEnginePower implements Serializable{

    DeltaEnginePowerLevel deltaEnginePowerLevel;
    boolean direction;

    public DeltaEnginePower(DeltaEnginePowerLevel deltaEnginePowerLevel, boolean direction) {
        this.deltaEnginePowerLevel = deltaEnginePowerLevel;
        this.direction = direction;
    }

    public DeltaEnginePowerLevel getDeltaEnginePowerLevel() {
        return deltaEnginePowerLevel;
    }

    public boolean isDirection() {
        return direction;
    }

    public double getDeltaEnginePower()
    {
        int sign = direction? 1:-1;

        return deltaEnginePowerLevel.getValue() * sign;
    }
}
