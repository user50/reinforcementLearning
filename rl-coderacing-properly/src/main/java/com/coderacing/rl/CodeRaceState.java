package com.coderacing.rl;

import com.coderacing.math.Vector;
import com.example.common.State;

import java.io.Serializable;

public class CodeRaceState implements State, Serializable {

    private Vector me;
    private Vector target;
    private Vector mySpeed;
    private double wheelTurn;
    private double enginePower;

    public CodeRaceState(Vector me, Vector target, Vector mySpeed, double wheelTurn, double enginePower) {
        this.me = me;
        this.target = target;
        this.mySpeed = mySpeed;
        this.wheelTurn = wheelTurn;
        this.enginePower = enginePower;
    }

    public Vector getMe() {
        return me;
    }

    public Vector getTarget() {
        return target;
    }

    public Vector getMySpeed() {
        return mySpeed;
    }

    public double getWheelTurn() {
        return wheelTurn;
    }

    public double getEnginePower() {
        return enginePower;
    }
}
