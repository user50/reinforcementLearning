package simulation;

/**
 * Created by user50 on 14.05.2015.
 */
public abstract class Gambler implements PokerPlayer {

    private int money;

    public Gambler(int money) {
        this.money = money;
    }

    public int getMoney()
    {
        return money;
    }

    public void decreaseMoney(int amount)
    {
        money-=amount;
    }
}
