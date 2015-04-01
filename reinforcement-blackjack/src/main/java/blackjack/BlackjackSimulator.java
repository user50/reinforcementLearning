package blackjack;

import com.example.common.Strategy;
import com.example.montecarlo.Simulator;
import com.example.montecarlo.Step;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by user50 on 03.01.2015.
 */
public class BlackjackSimulator implements Simulator {

    private CardsDesk cardsDesk;

    private boolean terminal = false;

    @Override
    public List<Step> generateEpisode(Strategy strategy) {
        cardsDesk = new CardsDesk();
        terminal = false;

        Player player = initPlayer();
        Player croupier = initPlayer();

        List<Step> steps = new ArrayList<Step>();
        while (!terminal)
            steps.add(generateStep(player, strategy, croupier));

        return steps;
    }

    private Step generateStep(Player player, Strategy strategy, Player croupier)
    {
        BlackjackState state = new BlackjackState(croupier.getCards().get(0), new ArrayList<Integer>(player.getCards()));
        BlackjackAction action = (BlackjackAction) strategy.generate(state);

        double rewards = 0;

        if ( action == BlackjackAction.hit ) {
            player.add(cardsDesk.pull());

            if (player.getTotal() > 21)
            {
                rewards = -1;
                terminal = true;
            }

        }
        else{
            while (croupier.getTotal() < 17)
                croupier.add(cardsDesk.pull());

            if (croupier.getTotal() > 21)
                rewards = 1;
            else if (croupier.getTotal() > player.getTotal())
                rewards = -1;
            else if (croupier.getTotal() < player.getTotal())
                rewards = 1;

            terminal = true;
        }

        return new Step(state, action, new BlackjackState(croupier.getCards().get(0), new ArrayList<Integer>(player.getCards())), rewards);
    }

    private Player initPlayer()
    {
        return new Player(Arrays.asList(cardsDesk.pull(), cardsDesk.pull()));
    }
}
