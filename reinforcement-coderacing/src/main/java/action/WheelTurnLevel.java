package action;

public enum  WheelTurnLevel {
    maximal(0.05), medium(0.002);

    double value;

    WheelTurnLevel(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
