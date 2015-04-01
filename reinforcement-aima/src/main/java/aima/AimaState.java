package aima;

import com.example.common.State;

/**
 * Created by user50 on 06.01.2015.
 */
public class AimaState implements State {
    int x;
    int y;

    public AimaState(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AimaState state = (AimaState) o;

        if (x != state.x) return false;
        if (y != state.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
