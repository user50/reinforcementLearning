package policy;

public class Action {

    double enginePower;
    double wheelTurn;

    public Action(double enginePower, double wheelTurn) {
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
