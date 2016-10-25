package continuous;

import abstractions.StateBuilder;
import math.Vector;
import math.VectorAlgebra;
import com.coderacing.model.Car;
import com.coderacing.model.Game;
import com.coderacing.model.Move;
import com.coderacing.model.World;

public class CRContinuousStateBuilder implements StateBuilder<CRContinuousState> {
    @Override
    public CRContinuousState build(Car self, World world, Game game, Move move) {
        double xTarget = self.getNextWaypointX() * game.getTrackTileSize() + 400;
        double yTarget = -self.getNextWaypointY() * game.getTrackTileSize() - 400;

        Vector target = new Vector(xTarget, yTarget);
        Vector me = new Vector(self.getX(), -self.getY());
        Vector me2target = VectorAlgebra.difference(target, me);

        double targetDistance = VectorAlgebra.length(me2target);

        Vector mySpeed = new Vector(self.getSpeedX(), -self.getSpeedY());
        double mySpeedValue = VectorAlgebra.length(mySpeed);

        double targetDirection = VectorAlgebra.angle(me2target, mySpeed);
        double enginePower = self.getEnginePower();
        double wheelTurn = self.getWheelTurn();

        return new CRContinuousState(targetDistance, targetDirection, mySpeedValue, wheelTurn, enginePower );
    }
}
