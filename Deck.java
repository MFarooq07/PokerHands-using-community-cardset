package proj4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;
public class Deck {
    int nextToDeal;
    private ArrayList<Card> deck;
    /**
     * this constructor makes a deck of 52 cards
     */
    public Deck() {
        this.deck = new ArrayList<>();
        this.nextToDeal = 0;
        makeCards();
    }
    /**
     * this function randomly shuffles the deck of card
     */
    public void shuffle() {
        for (int card = this.nextToDeal; card < this.deck.size(); card++) {
            Collections.swap(this.deck, card, ThreadLocalRandom.current().nextInt(card,
                    this.deck.size()));
        }
    }
    /**
     * the following method returns a card from the deck located at a certain index
     * @param index the index at which the card is located
     * @return card at the index provided
     */
    public Card getCard(int index){
        return this.deck.get(index);
    }
    /**
     * This function returns the size of the deck
     */
    public int getSize() {// we have to involve the nextToDeal
        return this.deck.subList(nextToDeal,this.deck.size()).size();
    }
    /**
     * This function helps in playing the game again by satrting to pick the cards from the deck from
     the very start
     */

/**
 * This method returns the cards that are not dealt while distributing the deck between the
 players
 * @return a String of undealt cards
 */
public String toString() {
    String undealtCards = "";
    int UNDEALT_CARDS = this.deck.size() -this.nextToDeal;
    for (int deckIndex = this.nextToDeal; deckIndex < getSize(); deckIndex++) {
        if (this.nextToDeal == this.deck.size() - UNDEALT_CARDS){
            undealtCards = undealtCards + String.valueOf(this.deck.get(deckIndex));
        }
        else undealtCards = undealtCards + ", " + String.valueOf(this.deck.get(deckIndex));
    }
    return undealtCards;
}
    /**
     * The following method makes all the cards in a deck
     */
    private void makeCards () {
        final ArrayList<String> suitList = new ArrayList<>(Arrays.asList("Diamonds", "Spades",
                "Hearts", "Clubs"));
        int MIN_RANK = 2;
        int MAX_RANK = 15;
        for (String suit : suitList) {
            for (int rank = MIN_RANK; rank < MAX_RANK; rank++) {
                if (rank < 11)
                {this.deck.add(new Card(String.valueOf(rank), suit));}
                else if (rank == 11){
                    this.deck.add(new Card("Jack", suit));
                }
                else if (rank == 12){
                    this.deck.add(new Card("Queen", suit));
                }
                else if (rank == 13){
                    this.deck.add(new Card("King", suit));
                }
                else this.deck.add(new Card("Ace", suit));
            }
        }
    }
    /**
     * the following method checks if the deck is empty or not
     * @return true or false based on the deck being empty or not
     */
    public boolean isEmpty(){
        int CARDS_IN_DECK =52;
        int CARDS_REQUIRED_FOR_TWO_HANDS = 4;
        return CARDS_IN_DECK - this.nextToDeal + 1 == CARDS_REQUIRED_FOR_TWO_HANDS;
    }
}