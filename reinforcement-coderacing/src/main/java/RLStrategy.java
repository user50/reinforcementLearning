import abstractions.ActionPerformer;
import abstractions.CodeRacingStrategy;
import abstractions.StateBuilder;
import com.example.common.Action;
import com.example.common.State;
import com.example.common.Strategy;
import model.Car;
import model.Game;
import model.Move;
import model.World;

public class RLStrategy<S extends State, A extends Action> implements CodeRacingStrategy {

    private Strategy<S, A> policy;
    private StateBuilder<S> stateBuilder;
    private ActionPerformer<A> actionPerformer;


    @Override
    public void move(Car self, World world, Game game, Move move) {
        S state = stateBuilder.build(self, world, game, move);
        A action = policy.generate(state);
        actionPerformer.perform(self, world, game, move, action);
    }
}
