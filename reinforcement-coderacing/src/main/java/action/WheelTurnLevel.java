package action;

public enum  WheelTurnLevel {
    maximal(0.05),high(0.015), medium(0.002), low(0.0005);

    double value;

    WheelTurnLevel(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
