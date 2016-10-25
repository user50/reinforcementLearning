package trivial;

import abstractions.RewardEvaluator;
import com.coderacing.model.*;

public class CodeRaceRewardEval implements RewardEvaluator {

    private int score = 0;

    @Override
    public double eval(Car self, World world, Game game, Move move) {
        return getReward(world);
    }

    private double getReward(World world)
    {
        for (Player player : world.getPlayers()) {
            if (player.getName().equals("MyStrategy")) {
                int reward = player.getScore() - score;
                score = player.getScore();

                if (reward>0)
                    System.out.println(player.getScore());

                return ((double)reward);
            }
        }

        throw new RuntimeException("Unable to find player: "+getClass().getName());
    }
}
