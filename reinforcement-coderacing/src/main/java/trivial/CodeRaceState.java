package trivial;

import com.example.common.State;

import java.io.Serializable;

public class CodeRaceState implements State, Serializable {

    int targetDirection;
    int wheelTurn;
    int leftWall;
    int rightWall;

    public CodeRaceState(int targetDirection, int wheelTurn, int leftWall, int rightWall) {
        this.targetDirection = targetDirection;
        this.wheelTurn = wheelTurn;
        this.leftWall = leftWall;
        this.rightWall = rightWall;
    }

    public int getTargetDirection() {
        return targetDirection;
    }

    public int getWheelTurn() {
        return wheelTurn;
    }

    public int getLeftWall() {
        return leftWall;
    }

    public int getRightWall() {
        return rightWall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CodeRaceState state = (CodeRaceState) o;

        if (targetDirection != state.targetDirection) return false;
        if (wheelTurn != state.wheelTurn) return false;
        if (leftWall != state.leftWall) return false;
        return rightWall == state.rightWall;

    }

    @Override
    public int hashCode() {
        int result = targetDirection;
        result = 31 * result + wheelTurn;
        result = 31 * result + leftWall;
        result = 31 * result + rightWall;
        return result;
    }
}
