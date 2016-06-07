package action;

import trivial.CodeRacingAction;

import java.util.ArrayList;
import java.util.List;

public class Actions {

    public static List<CodeRacingAction> getActions()
    {
        List<DeltaWheelTurn> deltaWheelTurns = new ArrayList<>();
        deltaWheelTurns.add(null);

        for (WheelTurnLevel wheelTurnLevel : WheelTurnLevel.values()) {
            deltaWheelTurns.add(new DeltaWheelTurn(wheelTurnLevel, true));
            deltaWheelTurns.add(new DeltaWheelTurn(wheelTurnLevel, false));
        }

        List<DeltaEnginePower> deltaEnginePowers  = new ArrayList<>();
        deltaEnginePowers.add(null);


        List<CodeRacingAction> actions = new ArrayList<>();

        for (DeltaWheelTurn deltaWheelTurn : deltaWheelTurns) {
            for (DeltaEnginePower deltaEnginePower : deltaEnginePowers) {
                actions.add(new CodeRacingAction(deltaWheelTurn, deltaEnginePower));
            }
        }

        return actions;
    }

    private static List<DeltaEnginePower> getEnginePowers()
    {
        List<DeltaEnginePower> deltaEnginePowers  = new ArrayList<>();
        deltaEnginePowers.add(null);

        for (DeltaEnginePowerLevel powerLevel : DeltaEnginePowerLevel.values()) {
            deltaEnginePowers.add(new DeltaEnginePower(powerLevel, true));
            deltaEnginePowers.add(new DeltaEnginePower(powerLevel, false));
        }

        return deltaEnginePowers;
    }

}
