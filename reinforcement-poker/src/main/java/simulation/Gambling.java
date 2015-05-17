package simulation;

import java.util.Map;

/**
 * Created by user50 on 14.05.2015.
 */
public class Gambling {

    Map<Gambler,Integer> betting;
    private int minBetAmount;

    private int maxBetting = 0;
    private int bank = 0;

    public Gambling(Map<Gambler, Integer> betting, int minBetAmount) {
        this.betting = betting;
        this.minBetAmount = minBetAmount;
    }

    public int getBank() {
        return bank;
    }

    public void onCheck(Gambler gambler)
    {
        if(maxBetting != betting.get(gambler))
            throw new IllegalStateException("Unable operation: check");
        //nothing to do
    }

    public void onFold(Gambler gambler)
    {
        //nothing to do
    }

    public void onRaise(Gambler gambler)
    {
        if(maxBetting == betting.get(gambler))
            throw new IllegalStateException("Unable operation: raise");

        int amount = (maxBetting - betting.get(gambler)) + minBetAmount;
        gambler.decreaseMoney(amount);
        bank += amount;

        maxBetting = betting.get(gambler) + amount;
        betting.put(gambler, maxBetting);
    }

    public void onCall(Gambler gambler)
    {
        if(maxBetting == betting.get(gambler))
            throw new IllegalStateException("Unable operation: call");

        int amount = maxBetting - betting.get(gambler);
        gambler.decreaseMoney(amount);
        bank += amount;
    }

    public void onBet(Gambler gambler)
    {
        if(maxBetting != betting.get(gambler))
            throw new IllegalStateException("Unable operation: bet");

        int amount = minBetAmount;
        gambler.decreaseMoney(amount);
        bank += amount;

        maxBetting = betting.get(gambler) + amount;
        betting.put(gambler, maxBetting);
    }


}
