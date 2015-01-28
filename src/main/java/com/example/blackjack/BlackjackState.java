package com.example.blackjack;

import com.example.common.State;
import com.example.util.Mathematics;

import java.util.List;

/**
 * Created by user50 on 03.01.2015.
 */
public class BlackjackState implements State {
    int croupierCard;
    List<Integer> cards;

    public BlackjackState(int croupierCard, List<Integer> cards) {
        this.croupierCard = croupierCard;
        this.cards = cards;
    }

    public int getCroupierCard() {
        return croupierCard;
    }

    public List<Integer> getCards() {
        return cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlackjackState that = (BlackjackState) o;

        if (croupierCard != that.croupierCard) return false;
        if (Mathematics.sum(cards) != Mathematics.sum(that.cards)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = croupierCard;

        result = 31 * result + Mathematics.sum(cards);
        return result;
    }
}
