package policy;

import com.example.common.State;
import math.Vector;

public class CodeRacingState implements State {

    double targetDistance;
    Vector speedDirection;

    public CodeRacingState(double targetDistance, Vector speedDirection) {
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
