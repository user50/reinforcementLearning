package policy;

import math.Vector;

public class State {

    double targetDistance;
    Vector speedDirection;

    public State(double targetDistance, Vector speedDirection) {
        this.targetDistance = targetDistance;
        this.speedDirection = speedDirection;
    }

    public double getTargetDistance() {
        return targetDistance;
    }

    public Vector getSpeedDirection() {
        return speedDirection;
    }

}
