package action;

public enum  WheelTurnLevel {
     medium(0.002);

    double value;

    WheelTurnLevel(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
