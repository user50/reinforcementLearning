package abstractions;

import com.example.common.Action;
import com.coderacing.model.Car;
import com.coderacing.model.Game;
import com.coderacing.model.Move;
import com.coderacing.model.World;

public interface ActionPerformer<A extends Action> {

    void perform(Car self, World world, Game game, Move move, A action);

}
