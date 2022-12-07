package proj4;
import java.util.ArrayList;
public class CommunityCardSet {
    private ArrayList<Card> communityCards;
    /**
     * the following constructor gets a set of community card set
     * @param cards this a list of the cards that are supposed to be
     * a set of community cards
     */
    public CommunityCardSet(ArrayList<Card> cards) {
        this.communityCards = cards;
    }
    /**
     * the following method gets the card in a list of community cards
     * present at specific index
     * @param indexOfCard index of a card
     * @return a card that is present at the provided index
     */
    public Card getIthCard(int indexOfCard){
        return this.communityCards.get(indexOfCard);
    }
    /**
     * the following method provides a display sample
     * @return display of the community card set
     */
    public String toString(){
        String displayCommunityCards = "";
        for (Card card : communityCards){
            if (card!= communityCards.get(communityCards.size()-1)){
                displayCommunityCards = displayCommunityCards + card + " | ";
            }
            else displayCommunityCards = displayCommunityCards + card;
        }
        return displayCommunityCards;
    }
    /**
     * the following method gets the size of the community card set
     * @return size of community card set
     */
    public int getSize(){
        return this.communityCards.size();
    }
}