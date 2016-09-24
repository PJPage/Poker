/**
 * Created by pagepj on 9/24/2016.
 */
public class Card {

    private int rank;
    private char suit;

    public Card(String cardString) { //cardString: 2 characters, 2-9 or TJQKA (number + schd (suit)
        char rankChar = cardString.charAt(0);
        if (Character.isDigit(rankChar)) {
            rank = Character.getNumericValue(rankChar);
        } else {
            switch (rankChar) {
                case 'T': rank = 10;
                    break;
                case 'J': rank = 11;
                    break;
                case 'Q': rank = 12;
                    break;
                case 'K': rank = 13;
                    break;
                case 'A': rank = 14;
                    break;
                default: System.out.println("Invalid card rank")
                    break;
            }
        }

        char suitChar = cardString.charAt(1);
        if (suitChar == 's' || suitChar == 'c' || suitChar == 'h' || suitChar == 'd') {
            suit = suitChar;
        } else {
            System.out.println("Invalid card suit");
        }

    }

    //getters
    public int getRank() {
        return rank;
    }
    public char getSuit() {
        return suit;
    }
}
