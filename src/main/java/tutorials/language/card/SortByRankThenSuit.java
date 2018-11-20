package tutorials.language.card;

import java.util.Comparator;

// Comparable是本身類的實現，Comparator傳遞到Collections sort函數上。
public class SortByRankThenSuit implements Comparator<Card> {
    @Override
    public int compare(Card firstCard, Card secondCard) {
        int compVal =
                firstCard.getRank().value() - secondCard.getRank().value();
        // 先比較排名，後比較花色。
        if (compVal != 0)
            return compVal;
        else
            return firstCard.getSuit().value() - secondCard.getSuit().value();
    }
}
