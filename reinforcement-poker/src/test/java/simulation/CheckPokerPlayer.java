package simulation;

/**
 * Created by user50 on 13.05.2015.
 */
public class CheckPokerPlayer extends ActionCountPokerPlayer {

    public Action makeDecision() {
        count++;

        return Action.check;
    }
}
