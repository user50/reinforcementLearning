package action;

public enum  WheelTurnLevel {
    maximal(0.05), high(0.02), medium(0.002);

    double value;

    WheelTurnLevel(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public WheelTurnLevel get(double value)
    {
        for (WheelTurnLevel wheelTurnLevel : WheelTurnLevel.values()) {
            if (wheelTurnLevel.getValue() == value)
                return wheelTurnLevel;
        }

        throw new RuntimeException("unable to find WheelTurnLevel");
    }
}
