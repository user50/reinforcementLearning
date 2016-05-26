package policy;

import com.example.common.Action;

public class CodeRacingAction implements Action {

    double enginePower;
    double wheelTurn;

    public CodeRacingAction(double enginePower, double wheelTurn) {
        this.enginePower = enginePower;
        this.wheelTurn = wheelTurn;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getWheelTurn() {
        return wheelTurn;
    }
}
