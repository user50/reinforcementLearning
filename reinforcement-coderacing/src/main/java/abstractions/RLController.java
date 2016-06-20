package abstractions;

import com.example.common.Action;
import com.example.common.State;
import com.example.common.Strategy;
import com.example.montecarlo.Step;
import model.Car;
import model.Game;
import model.Move;
import model.World;
import trivial.CodeRaceController;

import java.util.ArrayList;
import java.util.List;

public class RLController<S extends State, A extends Action> implements CodeRaceController {

    private Strategy<S, A> policy;
    private StateBuilder<S> stateBuilder;
    private ActionPerformer<A> actionPerformer;
    private RewardEvaluator rewardEvaluator;

    private S preState;
    private A preAction;

    List<Step<S, A>> steps = new ArrayList<>();

    public RLController(Strategy<S, A> policy,
                        StateBuilder<S> stateBuilder,
                        ActionPerformer<A> actionPerformer,
                        RewardEvaluator rewardEvaluator) {
        this.policy = policy;
        this.stateBuilder = stateBuilder;
        this.actionPerformer = actionPerformer;
        this.rewardEvaluator = rewardEvaluator;
    }

    @Override
    public void move(Car self, World world, Game game, Move move) {
        S state = stateBuilder.build(self, world, game, move);
        A action = policy.generate(state);

        double reward = rewardEvaluator.eval(self, world, game, move);

        if (preState != null && world.getTick() > 181) {
            steps.add(new Step<>(preState, preAction, state, reward));
        }

        preState = state;
        preAction = action;

        actionPerformer.perform(self, world, game, move, action);
    }

    public List<Step<S, A>> getSteps() {
        return steps;
    }
}
