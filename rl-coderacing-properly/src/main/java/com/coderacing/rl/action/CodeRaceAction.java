package com.coderacing.rl.action;


public class CodeRaceAction {

    private DeltaWheelTurn deltaWheelTurn;
    private DeltaEnginePower deltaEnginePower;

    public CodeRaceAction(DeltaWheelTurn deltaWheelTurn, DeltaEnginePower deltaEnginePower) {
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
