package trivial;

import abstractions.StateBuilder;
import model.Car;
import model.Game;
import model.Move;
import model.World;

public class CodeRacingStateBuilder implements StateBuilder<CodeRaceState> {
    @Override
    public CodeRaceState build(Car self, World world, Game game, Move move) {
        int x = (int)self.getX()/400;
        int y = (int)self.getY()/400;
        int speedX = 0; //LogScale.index(self.getSpeedX(), 0.05, 10, 4);
        int speedY = 0;// LogScale.index(self.getSpeedY(), 0.05, 10, 4);

        return new CodeRaceState(x, y, speedX, speedY);
    }
}
