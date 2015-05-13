package simulation;

/**
 * Created by user50 on 13.05.2015.
 */
public class FoldGambler extends ActionCountGambler {
    @Override
    public Action makeDecision() {
        count++;

        return Action.fold;
    }
}
