package trivial;

import abstractions.StateBuilder;
import math.LogScale;
import math.Vector;
import math.VectorAlgebra;
import com.coderacing.model.Car;
import com.coderacing.model.Game;
import com.coderacing.model.Move;
import com.coderacing.model.World;

public class CodeRacingStateBuilder implements StateBuilder<CodeRaceState> {
    @Override
    public CodeRaceState build(Car self, World world, Game game, Move move) {

        Vector me = new Vector(self.getX(), -self.getY());
        Vector target = new Vector(self.getNextWaypointX() * 800 + 400 , -self.getNextWaypointY() * 800 + 400);
        Vector mySpeed = new Vector(self.getSpeedX(), -self.getSpeedY());

        Vector me2target = VectorAlgebra.difference(target, me);

        double angle = VectorAlgebra.angle(mySpeed, me2target);

        int directionAngle = LogScale.index(angle, 0.02, 1, 5);
        int wheelTurn = LogScale.index(self.getWheelTurn(), 0.02, 0.4, 5);

        return new CodeRaceState(directionAngle, wheelTurn, leftWall(me), rightWall(me));
    }

    private int leftWall(Vector me)
    {
        if (me.getX() < 200)
            return 1;

        if (me.getY() > -200)
            return 1;

        return 0;
    }

    private int rightWall(Vector me)
    {
        if (me.getY() < -800 && me.getX() >600 && me.getX() <850 )
            return 1;

        if (me.getY() > -600 && me.getY() < -850 && me.getX() < 800 )
            return 1;

        return 0;
    }
}
