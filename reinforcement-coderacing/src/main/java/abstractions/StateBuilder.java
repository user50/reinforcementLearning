package abstractions;

import com.example.common.State;
import model.Car;
import model.Game;
import model.Move;
import model.World;

public interface StateBuilder<T extends State> {

    T build(Car self, World world, Game game, Move move);

}
