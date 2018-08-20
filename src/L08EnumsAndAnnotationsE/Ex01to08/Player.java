package L08EnumsAndAnnotationsE.Ex01to08;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> cards;

    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
    }

    public boolean isHandComplete() {
        return this.cards.size() == 5;
    }

    public void takeCard(Card card) {
        this.cards.add(card);
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public Card getHighestPowerCard() {
        return this.cards.stream().max(Card::compareTo).get();
    }

    @Override
    public String toString() {
        return this.name;
    }
}
