package simulation;

/**
 * Created by user50 on 13.05.2015.
 */
public abstract class ActionCountPokerPlayer extends Gambler {

    protected int count = 0;

    public ActionCountPokerPlayer() {
        super(100);
    }

    public int getCount() {
        return count;
    }
}
