package simulation;

/**
 * Created by user50 on 13.05.2015.
 */
public class CheckGambler extends ActionCountGambler {

    public Action makeDecision() {
        count++;

        return Action.check;
    }
}
