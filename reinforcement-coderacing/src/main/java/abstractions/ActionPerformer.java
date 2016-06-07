package abstractions;

import com.example.common.Action;
import model.Car;
import model.Game;
import model.Move;
import model.World;

public interface ActionPerformer<A extends Action> {

    void perform(Car self, World world, Game game, Move move, A action);

}
