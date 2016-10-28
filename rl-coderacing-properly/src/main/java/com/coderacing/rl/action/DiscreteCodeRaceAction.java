package com.coderacing.rl.action;

public class DiscreteCodeRaceAction implements CodeRaceAction {

    private DeltaWheelTurn deltaWheelTurn;
    private DeltaEnginePower deltaEnginePower;

    public DiscreteCodeRaceAction(DeltaWheelTurn deltaWheelTurn, DeltaEnginePower deltaEnginePower) {
        this.deltaWheelTurn = deltaWheelTurn;
        this.deltaEnginePower = deltaEnginePower;
    }

    public double getDeltaWheelTurn() {
        return deltaWheelTurn.getDeltaWheelTurn();
    }

    public double getDeltaEnginePower() {
        return deltaEnginePower.getDeltaEnginePower();
    }

}
