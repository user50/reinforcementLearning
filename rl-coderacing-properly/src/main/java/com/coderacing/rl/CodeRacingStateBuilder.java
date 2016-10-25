package com.coderacing.rl;

import com.coderacing.math.Vector;
import com.coderacing.model.Car;
import com.coderacing.model.Game;
import com.coderacing.model.Move;
import com.coderacing.model.World;

public class CodeRacingStateBuilder  {

    public CodeRaceState build(Car self, World world, Game game, Move move) {

        Vector me = new Vector(self.getX(), -self.getY());
        Vector target = new Vector(self.getNextWaypointX() * 800 + 400 , -self.getNextWaypointY() * 800 + 400);
        Vector mySpeed = new Vector(self.getSpeedX(), -self.getSpeedY());

        return new CodeRaceState(me, target, mySpeed, self.getWheelTurn(), self.getEnginePower());
    }

}
