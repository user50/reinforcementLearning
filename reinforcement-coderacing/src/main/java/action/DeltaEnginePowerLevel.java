package action;

public enum DeltaEnginePowerLevel {
    maximal(0.025),low(0.001);

    double value;

    DeltaEnginePowerLevel(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
