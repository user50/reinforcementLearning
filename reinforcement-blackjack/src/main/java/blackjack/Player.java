package blackjack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user50 on 03.01.2015.
 */
public class Player {
    List<Integer> cards = new ArrayList<Integer>();

    public Player(List<Integer> cards) {
        this.cards = new ArrayList<Integer>(cards);
    }

    public void add(int card)
    {
        cards.add(card);
    }

    public int getTotal()
    {
        int totalWithoutAces = 0;
        int aces = 0;

        for (Integer card : cards)
        {
            if (card == 11)
                aces++;
            else
                totalWithoutAces += card;
        }

        if (aces == 0)
            return totalWithoutAces;

        if (totalWithoutAces >= 11 || totalWithoutAces + 11 > 21)
            return totalWithoutAces + aces;

        return totalWithoutAces + 11 + aces - 1;
    }

    public List<Integer> getCards() {
        return cards;
    }
}
