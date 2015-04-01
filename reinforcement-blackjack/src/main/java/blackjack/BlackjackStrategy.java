package blackjack;

import com.example.common.Action;
import com.example.common.State;
import com.example.common.Strategy;

/**
 * Created by user50 on 03.01.2015.
 */
public class BlackjackStrategy implements Strategy {
    @Override
    public double calculate(State state, Action action) {
        return 0;
    }

    @Override
    public Action generate(State state) {

        int total = new Player(((BlackjackState)state).getCards()).getTotal();
        if (total < 19)
            return BlackjackAction.hit;


        return BlackjackAction.stick;
    }

    @Override
    public void update(State state, Action action) {

    }
}
