package abstractions;

import com.example.common.State;
import com.coderacing.model.Car;
import com.coderacing.model.Game;
import com.coderacing.model.Move;
import com.coderacing.model.World;

public interface StateBuilder<T extends State> {

    T build(Car self, World world, Game game, Move move);

}
