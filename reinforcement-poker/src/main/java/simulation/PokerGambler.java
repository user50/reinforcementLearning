package simulation;

/**
 * Created by user50 on 13.05.2015.
 */
public abstract class PokerGambler implements PokerPlayer {

    private int amount;

    protected PokerGambler(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
