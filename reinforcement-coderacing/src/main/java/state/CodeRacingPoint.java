package state;

import math.Vector;

import java.io.Serializable;

public class CodeRacingPoint implements Serializable {

    int targetDistance;
    int speedX;
    int speedY;
    int enginePower;
    int wheelTurn;
    int meX;
    int meY;

    public CodeRacingPoint(int targetDistance, int speedX, int speedY, int enginePower, int wheelTurn, int meX, int meY) {
        this.targetDistance = targetDistance;
        this.speedX = speedX;
        this.speedY = speedY;
        this.enginePower = enginePower;
        this.wheelTurn = wheelTurn;
        this.meX = meX;
        this.meY = meY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CodeRacingPoint that = (CodeRacingPoint) o;

        if (targetDistance != that.targetDistance) return false;
        if (speedX != that.speedX) return false;
        if (speedY != that.speedY) return false;
        if (enginePower != that.enginePower) return false;
        if (wheelTurn != that.wheelTurn) return false;
        if (meX != that.meX) return false;
        return meY == that.meY;

    }

    @Override
    public int hashCode() {
        int result = targetDistance;
        result = 31 * result + speedX;
        result = 31 * result + speedY;
        result = 31 * result + enginePower;
        result = 31 * result + wheelTurn;
        result = 31 * result + meX;
        result = 31 * result + meY;
        return result;
    }
}
