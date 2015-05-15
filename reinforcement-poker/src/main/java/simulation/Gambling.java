package simulation;

import java.util.Map;

/**
 * Created by user50 on 14.05.2015.
 */
public class Gambling {

    Map<Gambler,Integer> betting;
    private int raisingAmount;

    private int maxBetting = 0;
    private int bank = 0;

    public Gambling(Map<Gambler, Integer> betting, int raisingAmount) {
        this.betting = betting;
        this.raisingAmount = raisingAmount;
    }

    public int getBank() {
        return bank;
    }

    public void onCheck(Gambler gambler)
    {
        //nothing to do
    }

    public void onFold(Gambler gambler)
    {
        //nothing to do
    }

    public void onRaise(Gambler gambler)
    {
        if (!betting.containsKey(gambler))
            betting.put(gambler,0);

        int amount = (maxBetting - betting.get(gambler)) + raisingAmount;
        gambler.decreaseMoney(amount);
        bank += amount;

        maxBetting = betting.get(gambler) + amount;
        betting.put(gambler, maxBetting);
    }

    public void onCall(Gambler gambler)
    {
        if (!betting.containsKey(gambler))
            betting.put(gambler,0);

        int amount = maxBetting - betting.get(gambler);
        gambler.decreaseMoney(amount);
        bank += amount;
    }

    public void onBet(Gambler gambler)
    {
        if (!betting.containsKey(gambler))
            betting.put(gambler,0);

        int amount = (maxBetting - betting.get(gambler)) + raisingAmount;
        gambler.decreaseMoney(amount);
        bank += amount;

        maxBetting = betting.get(gambler) + amount;
        betting.put(gambler, maxBetting);
    }


}
