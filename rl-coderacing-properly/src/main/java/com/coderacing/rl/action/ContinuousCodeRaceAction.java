package com.coderacing.rl.action;

public class ContinuousCodeRaceAction implements CodeRaceAction {

    private double deltaWheelTurn;
    private double deltaEnginePower;

    public ContinuousCodeRaceAction(double deltaWheelTurn, double deltaEnginePower) {
        this.deltaWheelTurn = deltaWheelTurn;
        this.deltaEnginePower = deltaEnginePower;
    }

    @Override
    public double getDeltaWheelTurn() {
        return deltaWheelTurn;
    }

    @Override
    public double getDeltaEnginePower() {
        return deltaEnginePower;
    }
}
