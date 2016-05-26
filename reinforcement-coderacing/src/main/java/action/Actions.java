package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Actions {

    public static List<CodeRacingAction> getActions()
    {
        List<Optional<DeltaWheelTurn>> deltaWheelTurns = new ArrayList<>();
        deltaWheelTurns.add(Optional.empty());

        for (WheelTurnLevel wheelTurnLevel : WheelTurnLevel.values()) {
            deltaWheelTurns.add(Optional.of(new DeltaWheelTurn(wheelTurnLevel, true)));
            deltaWheelTurns.add(Optional.of(new DeltaWheelTurn(wheelTurnLevel, false)));
        }

        List<Optional<DeltaEnginePower>> deltaEnginePowers  = new ArrayList<>();
        deltaEnginePowers.add(Optional.empty());

        for (DeltaEnginePowerLevel powerLevel : DeltaEnginePowerLevel.values()) {
            deltaEnginePowers.add(Optional.of(new DeltaEnginePower(powerLevel, true)));
            deltaEnginePowers.add(Optional.of(new DeltaEnginePower(powerLevel, false)));
        }

        List<CodeRacingAction> actions = new ArrayList<>();

        for (Optional<DeltaWheelTurn> deltaWheelTurn : deltaWheelTurns) {
            for (Optional<DeltaEnginePower> deltaEnginePower : deltaEnginePowers) {
                actions.add(new CodeRacingAction(deltaWheelTurn, deltaEnginePower));
            }
        }

        return actions;
    }

}
