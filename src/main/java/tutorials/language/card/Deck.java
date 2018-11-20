package tutorials.language.card;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public interface Deck {

    List<Card> getCards();
    Deck deckFactory();

    int size();

    void addCard(Card card);
    void addCards(List<Card> cards);


    void addDeck(Deck deck);

    void shuffle();

    void sort();
    void sort(Comparator<Card> c);

    Map<Integer, Deck> deal(int players, int numberOfCards)
        throws IllegalArgumentException;
}
