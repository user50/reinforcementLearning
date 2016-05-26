package state;

import com.example.common.State;
import math.Vector;

public class CodeRacingState implements State {

    double targetDistance;
    Vector speedDirection;
    double enginePower;
    double wheelTurn;

    public CodeRacingState(double targetDistance, Vector speedDirection, double enginePower, double wheelTurn) {
        this.targetDistance = targetDistance;
        this.speedDirection = speedDirection;
        this.enginePower = enginePower;
        this.wheelTurn = wheelTurn;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CodeRacingState that = (CodeRacingState) o;

        if (Double.compare(that.targetDistance, targetDistance) != 0) return false;
        if (Double.compare(that.enginePower, enginePower) != 0) return false;
        if (Double.compare(that.wheelTurn, wheelTurn) != 0) return false;
        return !(speedDirection != null ? !speedDirection.equals(that.speedDirection) : that.speedDirection != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(targetDistance);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (speedDirection != null ? speedDirection.hashCode() : 0);
        temp = Double.doubleToLongBits(enginePower);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(wheelTurn);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
