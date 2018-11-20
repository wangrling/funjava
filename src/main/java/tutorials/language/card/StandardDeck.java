package tutorials.language.card;

import java.util.*;
import java.util.stream.Collectors;

public class StandardDeck implements Deck {

    private List<Card> entireDeck;

    public StandardDeck() {
        this.entireDeck = new ArrayList<>();
        for (Card.Suit s : Card.Suit.values()) {
            for (Card.Rank r : Card.Rank.values()) {
                this.entireDeck.add(new PlayingCard(r, s));
            }
        }
    }

    public StandardDeck(List<Card> existingList) {
        this.entireDeck = existingList;
    }

    @Override
    public List<Card> getCards() {
        return entireDeck;
    }

    @Override
    public Deck deckFactory() {
        return new StandardDeck(new ArrayList<Card>());
    }

    @Override
    public int size() {
        return entireDeck.size();
    }

    @Override
    public void addCard(Card card) {
        entireDeck.add(card);
    }

    @Override
    public void addCards(List<Card> cards) {
        entireDeck.addAll(cards);
    }

    @Override
    public void addDeck(Deck deck) {
        List<Card> listToAdd = deck.getCards();
        entireDeck.addAll(listToAdd);
    }

    @Override
    public void shuffle() {
        Collections.shuffle(entireDeck);
    }

    @Override
    public void sort() {
        Collections.sort(entireDeck);
    }

    @Override
    public void sort(Comparator<Card> c) {
        Collections.sort(entireDeck, c);
    }

    @Override
    public Map<Integer, Deck> deal(int players, int numberOfCards) throws IllegalArgumentException {

        // 需要處理的牌。
        int cardsDealt = players * numberOfCards;
        int sizeOfDeck = entireDeck.size();

        if (cardsDealt > sizeOfDeck) {
            if (cardsDealt > sizeOfDeck) {
                throw new IllegalArgumentException(
                        "Number of players (" + players +
                                ") times number of cards to be dealt (" + numberOfCards +
                                ") is greater than the number of cards in the deck (" +
                                sizeOfDeck + ").");
            }
        }

        // 將Card分配到相關的player那裏，然後剩餘的牌分配到n+1個選手那裏。
        Map<Integer, List<Card>> dealtDeck = entireDeck
                .stream()
                .collect(
                        Collectors.groupingBy(
                                card -> {
                                    int cardIndex = entireDeck.indexOf(card);
                                    if (cardIndex >= cardsDealt)
                                        return (players + 1);
                                    else
                                        return (cardIndex % players) + 1;
                                }
                        )
                );

        // Convert Map<Integer, List<Card>> to Map<Integer, Deck>
        Map<Integer, Deck> mapToReturn = new HashMap<>();

        for (int i = 1; i < (players + 1); i++) {
            Deck currentDeck = deckFactory();
            currentDeck.addCards(dealtDeck.get(i));
            mapToReturn.put(i, currentDeck);
        }

        return mapToReturn;
    }

    public String deckToString() {
        return this.entireDeck
                .stream().map(Card::toString)
                .collect(Collectors.joining("\n"));
    }

    public static void main(String... args) {
        StandardDeck myDeck = new StandardDeck();
        System.out.println("Creating deck: ");
        myDeck.sort();
        System.out.println("Sorted deck: ");
        System.out.println(myDeck.deckToString());

        myDeck.shuffle();
        myDeck.sort(new SortByRankThenSuit());
        System.out.println("Sorted by rank, then by suit: ");
        System.out.println(myDeck.deckToString());

        myDeck.shuffle();
        myDeck.sort(
                Comparator.comparing(Card::getRank)
                .thenComparing(Comparator.comparing(Card::getSuit)));
        System.out.println("Sorted by rank, then by suit " +
                "with static and default methods");
        System.out.println(myDeck.deckToString());

        myDeck.sort(
                Comparator.comparing(Card::getRank)
                .reversed()
                .thenComparing(Comparator.comparing(Card::getSuit)));
        System.out.println("Sorted by rank reversed, then by suit " +
                "with static and default methods");
        System.out.println(myDeck.deckToString());
    }
}
