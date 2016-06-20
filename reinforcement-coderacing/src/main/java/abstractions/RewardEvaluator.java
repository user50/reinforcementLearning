package abstractions;

import model.Car;
import model.Game;
import model.Move;
import model.World;

public interface RewardEvaluator {

    double eval(Car self, World world, Game game, Move move);
}
