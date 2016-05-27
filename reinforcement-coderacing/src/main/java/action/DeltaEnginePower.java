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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeltaEnginePower that = (DeltaEnginePower) o;

        if (direction != that.direction) return false;
        return deltaEnginePowerLevel == that.deltaEnginePowerLevel;

    }

    @Override
    public int hashCode() {
        int result = deltaEnginePowerLevel.hashCode();
        result = 31 * result + (direction ? 1 : 0);
        return result;
    }
}
