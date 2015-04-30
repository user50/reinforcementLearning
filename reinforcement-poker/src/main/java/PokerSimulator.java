import com.example.common.Strategy;
import com.example.montecarlo.Simulator;
import com.example.montecarlo.Step;
import reinforcement.PokerAction;
import reinforcement.PokerState;

import java.util.List;

/**
 * Created by user50 on 29.04.2015.
 */
public class PokerSimulator implements Simulator<PokerState, PokerAction> {


    @Override
    public List<Step<PokerState, PokerAction>> generateEpisode(Strategy strategy) {
        return null;
    }
}
