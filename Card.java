package proj4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
public class Card {
    private int rank;
    private String suit;
    /**
     * Creates a Card with a given rank and suit.
     *
     * @param rank The rank of the card, which must be between
     * 2 and 14, inclusive.
     * @param suit The suit of the card, which must be
     * 0=SPADES, 1=HEARTS, 2=CLUBS, or 3=DIAMONDS
     */
    public Card(int rank, int suit) {
        this.rank = rank;
        if (suit == 0) {
            this.suit = "Spades";
        }
        else if(suit == 1)
        {this.suit = "Hearts";
        }
        else if (suit == 2)
        {this.suit = "Clubs";
        }
        else this.suit = "Diamonds";
    }
    /**
     * Creates a Card with a given rank and suit.
     *
     * @param rank whole cards (2-10) can either be spelled
     * out like "two" or numeric like "2". Case
     * insensitive.
     * @param suit "Spades", "Hearts", "Clubs", or "Diamonds"
     */
    public Card(String rank, String suit) {
        this.suit = suit;
        if(!isConversionPossible(rank)){
            this.rank = rankConverter(rank);
        }
        else this.rank = Integer.parseInt(rank);
    }
    /**
     * the following method converts a string of rank to an integer type
     * @param rank rank of the card as a string
     * @return the rank of the card as integer
     */
    private int rankConverter(String rank){
        int FIRST_IN_RANK_LIST = 0;
        int INDEX_LAG_TO_RANK = 2;
        int SOMETHING = 0;
        final ArrayList<String> rankList = new ArrayList<>(Arrays.asList("two", "three", "four",
                "five","six","seven","eight","nine", "ten","jack","queen", "king", "ace"));
        for (int ranks =FIRST_IN_RANK_LIST; ranks < rankList.size() ; ranks++){
            if (rank.toLowerCase(Locale.ROOT).equals(rankList.get(ranks))){
                return ranks + INDEX_LAG_TO_RANK;
            }
        }return SOMETHING;}
    /**
     * determines whether a string can directly be converted to an integer
     * @param rank rank of the card of type string
     * @return true or false based on if it can be convert3ed into the integer
     */
    private boolean isConversionPossible(String rank){
        try {
            int intValue = Integer.parseInt(rank);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    /**
     * this method provides the rank of a card
     * @return suit of a suit
     */
    public int getRank(){
        return this.rank;
    }
    /**
     * this method provides the suit of a card
     * @return suit of a card
     */
    public String getSuit() {
        return this.suit;
    }
    /**
     *provides a presentable form of the cards
     * @return cards
     */
    public String toString() {
        if (this.rank < 11) {
            return this.rank + " of " + this.suit;
        } else if (this.rank == 11) {
            return "Jack of " + this.suit;
        } else if (this.rank == 12) {
            return "Queen of " + this.suit;
        } else if (this.rank == 13) {
            return "King of " + this.suit;
        } else if (this.rank == 14) {
            return "Ace of " + this.suit;
        } else {
            return this.rank + " " + this.suit;
        }
    }

}