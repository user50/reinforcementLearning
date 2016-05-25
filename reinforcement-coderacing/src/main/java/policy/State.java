package policy;

import math.Vector;

public class State {

    Vector myPosition;
    Vector mySpeed;
    Vector nextWayTail;
    int tick;

    public State(Vector myPosition, Vector mySpeed, Vector nextWayTail, int tick) {
        this.myPosition = myPosition;
        this.mySpeed = mySpeed;
        this.nextWayTail = nextWayTail;
        this.tick = tick;
    }

    public Vector getMyPosition() {
        return myPosition;
    }

    public Vector getMySpeed() {
        return mySpeed;
    }

    public Vector getNextWayTail() {
        return nextWayTail;
    }

    public int getTick() {
        return tick;
    }
}
