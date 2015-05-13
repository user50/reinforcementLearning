package simulation;

import java.util.List;

/**
 * Created by user50 on 08.05.2015.
 */
public class PokerRound {

    List<? extends PokerPlayer> gamblers;

    public PokerRound(List<? extends PokerPlayer> gamblers) {
        this.gamblers = gamblers;
    }

    public void play()
    {
        int raisedPlayer = 0;

        int turn = 0;
        do {
            PokerPlayer pokerPlayer = gamblers.get(turn % gamblers.size());
            Action action = pokerPlayer.makeDecision();

            if (action == Action.fold)
                gamblers.remove(turn % gamblers.size());

            if (action == Action.check)
                turn ++;

            if (action == Action.raise) {
                raisedPlayer = turn % gamblers.size();
                turn++;
            }

        }while ( turn % gamblers.size() != raisedPlayer );
    }

}
