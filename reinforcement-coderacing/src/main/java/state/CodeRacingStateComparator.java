package state;

import com.example.common.State;
import math.LogScale;
import state.CodeRacingState;

import java.util.Comparator;

public class CodeRacingStateComparator implements Comparator<State> {
    @Override
    public int compare(State one, State two) {
        CodeRacingState stateOne = (CodeRacingState)one;
        CodeRacingState stateTwo = (CodeRacingState)two;

        int result = new Integer((int)stateOne.getTargetDistance() / 800).compareTo((int)stateTwo.getTargetDistance() / 800);

        if (result == 0) {
            int indexOne = LogScale.index(1 - stateOne.getSpeedDirection().getX(),0.0005, 0.05, 10  );
            int indexTwo = LogScale.index(1 - stateTwo.getSpeedDirection().getX(),0.0005, 0.05, 10  );
            result = new Integer(indexOne).compareTo(indexTwo);
        }

        if (result == 0)
        {
            int indexOne = LogScale.index(1 - stateOne.getSpeedDirection().getY(),0.0005, 0.05, 10  );
            int indexTwo = LogScale.index(1 - stateTwo.getSpeedDirection().getY(),0.0005, 0.05, 10  );
            result = new Integer(indexOne).compareTo(indexTwo);
        }

        if (result == 0)
        {
            int indexOne = LogScale.index(1 - stateOne.getWheelTurn(),0.0005, 0.05, 10  );
            int indexTwo = LogScale.index(1 - stateTwo.getWheelTurn(),0.0005, 0.05, 10  );
            result = new Integer(indexOne).compareTo(indexTwo);
        }

        if (result == 0)
        {
            int indexOne = (int) (Math.abs(stateOne.getEnginePower())/0.1)  * (int)Math.signum(stateOne.getEnginePower());
            int indexTwo = (int) (Math.abs(stateTwo.getEnginePower())/0.1)  * (int)Math.signum(stateTwo.getEnginePower());
            result = new Integer(indexOne).compareTo(indexTwo);
        }

        return result;
    }
}
