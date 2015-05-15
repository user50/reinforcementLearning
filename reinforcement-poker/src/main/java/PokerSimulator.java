import com.example.common.Strategy;
import com.example.montecarlo.Simulator;
import com.example.montecarlo.Step;
import reinforcement.PokerAction;
import reinforcement.PokerState;
import simulation.Action;
import simulation.Gambler;
import simulation.Gambling;
import simulation.PokerRound;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by user50 on 29.04.2015.
 */
public class PokerSimulator implements Simulator<PokerState, PokerAction> {

    public static void main(String[] args) {
        List<Gambler> gamblers = Arrays.asList(new BetGambler(100), new CallGambler(100));

        PokerRound pokerRound = new PokerRound(gamblers, new Gambling(new HashMap<>(), 10));

        pokerRound.play();


    }

    @Override
    public List<Step<PokerState, PokerAction>> generateEpisode(Strategy strategy) {
        return null;
    }

    public static class BetGambler extends Gambler {

        public BetGambler(int money) {
            super(money);
        }

        @Override
        public Action makeDecision() {
            return Action.bet;
        }
    }

    public static class CallGambler extends Gambler {

        public CallGambler(int money) {
            super(money);
        }

        @Override
        public Action makeDecision() {
            return Action.call;
        }
    }


}
