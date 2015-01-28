package com.example.blackjack;

import com.example.util.Mathematics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user50 on 03.01.2015.
 */
public class CardsDesk {

    List<Integer> cards = new ArrayList<Integer>();

    public CardsDesk() {
        add(2, 4);
        add(3, 4);
        add(4, 4);
        add(5, 4);
        add(6, 4);
        add(7, 4);
        add(8, 4);
        add(9, 4);
        add(10, 4 + 4 + 4 + 4);
        add(11, 4);
    }

    public int pull()
    {
        int index = Mathematics.randInt(0, cards.size() - 1);
        int card = cards.get(index);
        cards.remove(index);

        return card;
    }

    private void add(int card, int quantity)
    {
        for (int i = 0; i < quantity; i++)
            cards.add(card);

    }


}
