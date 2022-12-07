package proj4;
import java.util.ArrayList;
public class StudPokerHand {
    private ArrayList<Card> twoCardHand;
    private CommunityCardSet communityCardSet;
    private int FIRST_CARD =0;
    /**
     * the following constructor takes a two card hand and a set of community
     * cards
     * @param cc a set of community cards
     * @param twoCardHand cards in a hand
     */
    public StudPokerHand (CommunityCardSet cc, ArrayList<Card> twoCardHand){
        this.twoCardHand = twoCardHand;
        this.communityCardSet = cc;
    }
    /**
     * The following method helps in getting the card at the provided index
     * @param index index of the card in a list
     * @return the card at that index
     */
    public Card getIthCard (int index){return this.twoCardHand.get(index);}
    /**
     * the following method provides displaying interface that makes the set
     * of two card hands presentable
     * @return presentable display
     */
    public String toString(){
        String displayHand = "";
        for (int card = FIRST_CARD; card < this.twoCardHand.size();card++){
            if (card != this.twoCardHand.size()-1){
                displayHand = displayHand + this.twoCardHand.get(card) + ", ";
            }else displayHand = displayHand + this.twoCardHand.get(card);
        }
        return displayHand;}
    /**
     * Determines how this hand compares to another hand, using the
     * community card set to determine the best 5-card hand it can
     * make. Returns positive, negative, or zero depending on the
     * comparison.
     *
     * @param other The hand to compare this hand to
     * @return a negative number if this is worth LESS than other, zero
     * if they are worth the SAME, and a positive number if this is worth
     * MORE than other
     */
    public int compareTo(StudPokerHand other) {
        PokerHand bestHand1 = this.getBestFiveCardHand();
        PokerHand bestHand2 = other.getBestFiveCardHand();
        return bestHand1.compareTo(bestHand2);
    }
    /**
     * The following method makes all the gets all the possible
     * combinations
     * from a set of cards containing community cards and the cards in
     * two hands
     * @return all the possible combinations in a given set of cards of
     * some size
     */
    private ArrayList<PokerHand> getAllFiveCardHands(){
        ArrayList<Card> listOfAllCardsInCombo;
        listOfAllCardsInCombo = makeSetOfAllCards();
        ArrayList<ArrayList<Card>> listOfAllHands = makePossibleCombos(listOfAllCardsInCombo,5);
        return convertToPokerHands(listOfAllHands);
    }
    /**
     * the following method makes a set of all cards from which the combos
     * are going to be made
     * @return
     */
    private ArrayList<Card> makeSetOfAllCards(){
        ArrayList<Card> listOfAllCardsInCombo = new ArrayList<>();
        for (int card = FIRST_CARD; card < this.communityCardSet.getSize(); card++){
            listOfAllCardsInCombo.add(this.communityCardSet.getIthCard(card));
        }listOfAllCardsInCombo.addAll(this.twoCardHand);
        return listOfAllCardsInCombo;
    }
    /**
     * the following method converts the list of lists of combos of type
     * card
     * into a single list of type pokerhand
     *
     * @param allHands a list of lists of all possible combos that can be
     * formed from a set of cards
     * @return a list containing all the possible combos of type pokerhand
     */
    private ArrayList<PokerHand> convertToPokerHands(ArrayList<ArrayList<Card>> allHands ){
        ArrayList<PokerHand> listOfAllHands= new ArrayList<>();
        for ( ArrayList<Card> hand: allHands){
            PokerHand handInAllCombo = new PokerHand(hand);
            listOfAllHands.add(handInAllCombo);
        }
        return listOfAllHands;
    }
    /**
     * This method makes all the possible combinations, getting the
     * combinations
     * that are formed with or without the first card ina set of cards
     * @param listOfAllCardsInCombo this a list of all cards from which
     * the combinations are supposed to be
     * made
     * @param sizeOfCombos this is the size of each combination in a set
     * of cards
     * @return all the possible combinations of specific size in a given
     * set of cards
     */
    private ArrayList<ArrayList<Card>> makePossibleCombos(ArrayList<Card> listOfAllCardsInCombo, int
            sizeOfCombos ) {
        if (sizeOfCombos == 1) {
            return makeListOfComboSize1(listOfAllCardsInCombo);
        }
        if (listOfAllCardsInCombo.size() == sizeOfCombos) {
            ArrayList<ArrayList<Card>> allComboList = new ArrayList<>();
            allComboList.add(listOfAllCardsInCombo);
            return allComboList;
        }
        Card firstCard = listOfAllCardsInCombo.get(FIRST_CARD);
        ArrayList<Card> restList = new ArrayList<Card>(listOfAllCardsInCombo.subList(1,
                listOfAllCardsInCombo.size()));
        ArrayList<ArrayList<Card>> comboWithFirst =
                combosWithFirstCard(firstCard,restList,sizeOfCombos);
        ArrayList<ArrayList<Card>> comboWithoutFirst = makePossibleCombos(restList,
                sizeOfCombos);
        return mergeSeparateCombos(comboWithFirst,comboWithoutFirst);
    }
    /**
     * the following method makes the combinations of size one from a
     * list of cards
     * @param listOfAllCardsInCombo this a set of cards
     * @return combinations of size one from a set of cards
     */
    private ArrayList<ArrayList<Card>> makeListOfComboSize1(ArrayList<Card> listOfAllCardsInCombo) {
        ArrayList<ArrayList<Card>> allComboList = new ArrayList<>();
        for (int cardInList = FIRST_CARD; cardInList < listOfAllCardsInCombo.size(); cardInList++) {
            ArrayList<Card> card = new ArrayList<>();
            card.add(listOfAllCardsInCombo.get(cardInList));
            allComboList.add(card);
        }
        return allComboList;
    }
    /**
     *
     * @param firstCardInList first card in a set of cards
     * @param restList all the cards other than the first card
     * @param sizeOfCombos this is the size of each combination
     * that is expected to be made
     * @return all the possible combinations that include the
     * first card
     */
    private ArrayList<ArrayList<Card>> combosWithFirstCard(Card firstCardInList,ArrayList<Card>
            restList, int sizeOfCombos ){
        ArrayList<ArrayList<Card>> combosWithFirstCard = new ArrayList<>();
        ArrayList<ArrayList<Card>> combosOfRestCards = makePossibleCombos(restList, sizeOfCombos-1);
        for (ArrayList<Card> aCombo: combosOfRestCards){
            aCombo.add(firstCardInList);
            combosWithFirstCard.add(aCombo);
        }
        return combosWithFirstCard;
    }
    /**
     * the following method returns a list of all the possible
     * combinations of a certain size from a given set of cards
     * @param comboWithFirst all the possible combinations made WITH
     * the first card in a list
     * @param comboWithoutFirst all the possible combinations made
     * WITHOUT the first card in a list
     * @return all possible combinations from card set
     */
    private ArrayList<ArrayList<Card>> mergeSeparateCombos(ArrayList<ArrayList<Card>> comboWithFirst,
                                                           ArrayList<ArrayList<Card>> comboWithoutFirst){
        ArrayList<ArrayList<Card>> allComboPack = new ArrayList<>();
        allComboPack.addAll(comboWithFirst);
        allComboPack.addAll(comboWithoutFirst);
        return allComboPack;
    }
    /**
     * this method gets the best of all the hands that a user can make
     * @return the best hand/combination in all the hands/combinations
     */
    private PokerHand getBestFiveCardHand () {
        ArrayList<PokerHand> hands = this.getAllFiveCardHands();
        PokerHand bestSoFar = hands.get(0);
        for (int hand = 1; hand < hands.size(); hand++) {
            if (hands.get(hand).compareTo(bestSoFar) > 0) {
                bestSoFar = hands.get(hand);
            }
        }
        return bestSoFar;
    }
}