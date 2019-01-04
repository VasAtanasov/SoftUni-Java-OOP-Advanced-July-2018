package L08EnumsAndAnnotationsE.Ex01to08;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Deck {
    private List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        this.seedDeck();
    }

    private void seedDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                this.cards.add(new Card(suit, rank));
            }
        }
    }

    public boolean contains(Card card) {
        return this.cards.stream().anyMatch(compareCards(card));
    }

    public void draw(Card card) {
        this.cards.removeIf(compareCards(card));
    }

    private Predicate<Card> compareCards(Card card) {
        return c -> c.compareTo(card) == 0;
    }
}
