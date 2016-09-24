/**
 * Created by pagepj on 9/24/2016.
 */
public class Poker {
    public static void main(String[] args) {

    }
    public static int handScore(Card[] cards) {
        /*
        1st digit: type of score (0-9, high card up to royal flush)
        2nd-4th digits:
         */
        int score = 0;

        //royal flush
        if (sameSuit(cards) && isStraight(cards) && lowestRank(cards) == 10) {
            score += 90000;
        }
        //straight flush
        else if (sameSuit(cards) && isStraight(cards)) {
            score += 80000;
        }
        //four of a kind
        else if (matchingCards(cards)[0] == 4 || matchingCards(cards)[1] == 4) {
            score += 70000;
        }
        //full house
        else if ((matchingCards(cards)[0] == 3 || matchingCards(cards)[1] == 3) &&
                (matchingCards(cards)[0] == 2 || matchingCards(cards)[1] == 2)) {
            score += 60000;
        }
        //flush
        else if (sameSuit(cards)) {
            score += 50000;
        }
        //straight
        else if (isStright(cards)) {
            score += 40000;
        }
        //three of a kind
        else if (matchingCards(cards)[0] == 3 || matchingCards(cards)[1] == 3) {
            score += 30000;
        }
        //two pair
        else if (matchingCards(cards)[0] == 2 && matchingCards(cards)[1] == 2) {
            score += 20000;
        }
        //pair
        else if (matchingCards(cards)[0] == 2 || matchingCards(cards)[1] == 2) {
            score += 10000;
        }
    }
    public static boolean sameSuit(Card[] cards) {
        char suit = cards[0].getSuit();
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].getSuit() != suit) {
                return false;
            }
        }
        return true;
    }
    public static boolean containsRank(Card[] cards, int rank) {
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].getRank() == rank) {
                return true;
            }
        }
        return false;
    }
    public static int lowestRank(Card[] cards) {
        int lowRank = 15;
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].getRank() < lowRank) {
                lowRank = cards[i].getRank();
            }
        }
        return lowRank;
    }
    public static int[] matchingCards(Card[] cards) {
        //FIX: make it recognize different sets of cards, e.g. full house
        int[] matches = {1, 1};
        int numMatchingCards;
        for (int i = 0; i < cards.length; i++) {
            numMatchingCards = 1;
            for (int j = 0; j < cards.length; j++) {
                if (j != i && cards[i].getRank() == cards[j].getRank()) {
                    numMatchingCards++;
                }
            }
            if (numMatchingCards > 1) {
                if (matches[0] == numMatchingCards) {
                    matches[1] = numMatchingCards;
                } else {
                    matches[0] = numMatchingCards;
                }
            }
        }
        return matches;
    }
    public static boolean isStraight(Card[] cards) {

        int lowRank = lowestRank(cards);
        if (containsRank(cards, lowRank + 1) && containsRank(cards, lowRank + 2) &&
                containsRank(cards, lowRank + 3) && containsRank(cards, lowRank + 4)) {
            return true;
        }
        else if (containsRank(cards, 14) && containsRank(cards, 2) && containsRank(cards, 3) &&
                containsRank(cards, 4) && containsRank(cards, 5)) {
            return true;

        } else {
            return false;
        }
    }
    public static Card[] parseCardString(String cardString) {
         Card[5] cards;
        for (int i = 0; i < cardString.length; i += 2) {

        }
    }

}
