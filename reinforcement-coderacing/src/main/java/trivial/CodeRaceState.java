package trivial;

import com.example.common.State;

import java.io.Serializable;

public class CodeRaceState implements State, Serializable {

    int x;
    int y;
    int speedX;
    int speedY;

    public CodeRaceState(int x, int y, int speedX, int speedY) {
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CodeRaceState that = (CodeRaceState) o;

        if (x != that.x) return false;
        if (y != that.y) return false;
        if (speedX != that.speedX) return false;
        return speedY == that.speedY;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + speedX;
        result = 31 * result + speedY;
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                ", speedX=" + speedX +
                ", speedY=" + speedY +
                '}';
    }
}
