package abstractions;

import com.coderacing.model.Car;
import com.coderacing.model.Game;
import com.coderacing.model.Move;
import com.coderacing.model.World;

public interface RewardEvaluator {

    double eval(Car self, World world, Game game, Move move);
}
