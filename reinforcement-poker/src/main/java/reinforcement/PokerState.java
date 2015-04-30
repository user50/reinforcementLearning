package reinforcement;

import com.example.common.State;
import texasholdem.Card;

import java.util.Set;

public class PokerState implements State {

    private Set<Card> handCards;
    private Set<Card> deckCards;

    public PokerState(Set<Card> handCards, Set<Card> deckCards) {
        this.handCards = handCards;
        this.deckCards = deckCards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PokerState that = (PokerState) o;

        if (!deckCards.equals(that.deckCards)) return false;
        if (!handCards.equals(that.handCards)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = handCards.hashCode();
        result = 31 * result + deckCards.hashCode();
        return result;
    }
}
