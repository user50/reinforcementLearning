package continuous;

import com.example.common.State;

public class CRContinuousState implements State{

    private double targetDistance;
    private double targetDirection;
    private double speed;
    private double wheelTurn;
    private double enginePower;

    public CRContinuousState(double targetDistance, double targetDirection, double speed, double wheelTurn, double enginePower) {
        this.targetDistance = targetDistance;
        this.targetDirection = targetDirection;
        this.speed = speed;
        this.wheelTurn = wheelTurn;
        this.enginePower = enginePower;
    }

    public double getTargetDistance() {
        return targetDistance;
    }

    public double getTargetDirection() {
        return targetDirection;
    }

    public double getSpeed() {
        return speed;
    }

    public double getWheelTurn() {
        return wheelTurn;
    }

    public double getEnginePower() {
        return enginePower;
    }
}
