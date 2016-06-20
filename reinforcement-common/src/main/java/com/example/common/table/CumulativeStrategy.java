package com.example.common.table;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user50 on 30.01.2015.
 */
public class CumulativeStrategy<Arg> implements UpdateTableStrategy<Arg> {

    Map<Arg, Double> totalRewardPerArg = new HashMap<Arg, Double>();
    Map<Arg, Integer> totalVisits = new HashMap<Arg, Integer>();

    public CumulativeStrategy(Map<Arg, Double> totalRewardPerArg, Map<Arg, Integer> totalVisits) {
        this.totalRewardPerArg = totalRewardPerArg;
        this.totalVisits = totalVisits;
    }

    public CumulativeStrategy() {
    }

    @Override
    public void update(Map<Arg, Double> table, Arg arg, double value) {
        if (!totalRewardPerArg.containsKey(arg))
        {
            totalRewardPerArg.put(arg, 0.0);
            totalVisits.put(arg, 0);
        }

        totalRewardPerArg.put(arg, totalRewardPerArg.get(arg) + value);
        totalVisits.put(arg, totalVisits.get(arg) + 1);

        update(table, arg);
    }

    private void update(Map<Arg, Double> table, Arg arg)
    {
        double totalReward = totalRewardPerArg.get(arg);
        int totalVisit = totalVisits.get(arg);

        table.put(arg, totalReward / totalVisit );
    }
}
