package state;

import math.LogScale;

public class CodeRacingStateUtil {

    public static CodeRacingPoint from(CodeRacingState state)
    {
        int targetDistance = (int)state.getTargetDistance() / 800;

        int speedX = LogScale.index(1 - state.getSpeedDirection().getX(), 0.0005, 0.05, 10);

        int speedY = LogScale.index(1 - state.getSpeedDirection().getY(),0.0005, 0.05, 10  );

        int wheelTurn = LogScale.index(1 - state.getWheelTurn(),0.0005, 0.05, 10  );

        int enginePower = (int) (Math.abs(state.getEnginePower())/0.1)  * (int)Math.signum(state.getEnginePower());

        int meX = (int)(state.getMe().getX()/800);
        int meY = (int)(state.getMe().getY()/800);

        return new CodeRacingPoint(targetDistance, speedX, speedY, enginePower, wheelTurn, meX, meY );
    }

}
