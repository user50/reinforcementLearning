package state;

import com.example.common.State;
import math.Vector;

import java.io.Serializable;

public class CodeRacingState implements State, Serializable {

    double targetDistance;
    Vector speedDirection;
    double enginePower;
    double wheelTurn;
    Vector me;

    CodeRacingPoint point;

    public CodeRacingState(double targetDistance, Vector speedDirection, double enginePower, double wheelTurn, Vector me) {
        this.targetDistance = targetDistance;
        this.speedDirection = speedDirection;
        this.enginePower = enginePower;
        this.wheelTurn = wheelTurn;
        this.me = me;

        point = CodeRacingStateUtil.from(this);
    }

    public double getTargetDistance() {
        return targetDistance;
    }

    public Vector getSpeedDirection() {
        return speedDirection;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getWheelTurn() {
        return wheelTurn;
    }

    public Vector getMe() {
        return me;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CodeRacingState that = (CodeRacingState) o;

        return point.equals(that.point);

    }

    @Override
    public int hashCode() {
        return point.hashCode();
    }
}
