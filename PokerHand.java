package proj4;
import java.util.Collections;
import java.util.stream.*;
import java.util.ArrayList;
import java.util.Objects;
public class PokerHand {
    private ArrayList<Card> cardList;
    /**
     * the following constructor takes a cardlist as a pokerhand
     * @param cardList a set of pokerhand cards
     */
    public PokerHand(ArrayList<Card> cardList) {
        this.cardList = cardList;
    }
    int PLAYER1_WON = 1;
    int PLAYER2_WON = -1;
    int NO_WINNER = 0;
    /**
     * determines the hand which is more worth
     * @param other hand of player2 for comparison
     * @return winner of the Pokerhand
     */
    public int compareTo(PokerHand other) {
        ArrayList<Integer> ranksOfCards1 = this.rankCollector();
        ArrayList<Integer> ranksOfCards2 = other.rankCollector();
        int flushCaseWinner = flushWinner(this.cardList, other.cardList, ranksOfCards1,
                ranksOfCards2);
        if (flushCaseWinner != 0) {
            return flushCaseWinner;
        }
        else {
            int pairCaseWinner = pairsOrHighRankWinner(ranksOfCards1, ranksOfCards2);
            if (pairCaseWinner!=0){
                return pairCaseWinner;
            }
        }
        return NO_WINNER;
    }
    /**
     * The following method collects the ranks of the cards in a hand
     * @return a list of ranks of cards in a hand
     */
    private ArrayList<Integer> rankCollector() {
        ArrayList<Integer> ranksOfHand = new ArrayList<Integer>();
        for (Card value : this.cardList) {
            ranksOfHand.add(value.getRank());
        }
        ranksOfHand = (ArrayList<Integer>)
                ranksOfHand.stream().sorted().collect(Collectors.toList());
        return ranksOfHand;
    }
    /** Master function of flush that determines whether a hand wins as flush or not
     * @param cardList1 : list of cards in hand 1
     * @param cardList2 : list of cards in hand 2
     * @return the winner or undecided winner
     */
    private int flushWinner(ArrayList<Card> cardList1, ArrayList<Card> cardList2, ArrayList<Integer>
            ranksOfCards1, ArrayList<Integer> ranksOfCards2) {
        boolean isHand1Flush = isFlush(cardList1);
        boolean isHand2Flush = isFlush(cardList2);
        int winner = whoWonFlush(isHand1Flush, isHand2Flush);
        if (winner != 0) {
            return winner;
        } else if (isHand1Flush && isHand2Flush) {
            int isWinner = whoWonHighRank(ranksOfCards1, ranksOfCards2);
            if (isWinner != NO_WINNER) {
                return isWinner;
            }
        }
        return NO_WINNER;
    }
    /** Determines whether a hand is a flush or not
     * @param : list of cards in hand
     * @return true or a false statement based on the fact if a hand is a flush or not
     */
    private boolean isFlush(ArrayList<Card> cardList) {
        int FIRST_CARD = 0;
        for (int card = FIRST_CARD; card < cardList.size() - 1; card++) {
            int NEXT_CARD= card +1;
            if (!Objects.equals(cardList.get(card).getSuit(), cardList.get(NEXT_CARD).getSuit())) {
                return false;
            }
        }
        return true;
    }
    /**Determines whether a hand wins as flush or not
     * @param isFLush1 : whether hand1 is a flush or not
     * @param isFLush2 : whether hand2 is a flush or not
     * @return the winner or undecided winner
     *
     */
    private int whoWonFlush(boolean isFLush1, boolean isFLush2) {
        if (isFLush1 && !isFLush2) {
            return PLAYER1_WON;
        } else if (!isFLush1 && isFLush2) {
            return PLAYER2_WON;
        } else return NO_WINNER;
    }
    /**Determines if either of hands has a higher rank card than the other
     * @param cardList1 : list of cards in hand 1
     * @param cardList2 : list of cards in hand 2
     * @return the winner or tie result
     *
     */
    private int whoWonHighRank(ArrayList<Integer> cardList1, ArrayList<Integer> cardList2) {
        if (cardList1.size() < cardList2.size() || cardList2.size() < cardList1.size()) {
            if (cardList1.size() < cardList2.size()) {
                cardList1.add(0);
            } else
                cardList2.add(0);
            for (int cardRank = 0; cardRank < cardList1.size(); cardRank++) {
                if (cardList1.get(cardRank) > cardList2.get(cardRank)) {
                    return PLAYER1_WON;
                } else if (cardList1.get(cardRank) < cardList2.get(cardRank)) {
                    return PLAYER2_WON;
                }
            }
            return NO_WINNER;
        }
        else
            for (int cardRank = cardList1.size() - 1; cardRank >= 0; cardRank--) {
                if (cardList1.get(cardRank) > cardList2.get(cardRank)) {
                    return PLAYER1_WON;
                } else if (cardList1.get(cardRank) < cardList2.get(cardRank)) {
                    return PLAYER2_WON;
                }
            }
        return NO_WINNER;
    }
    /**
     * Determines a winner on the parameters of pair(s) or highrank
     * @param cardList1 : list of cards in hand 1
     * @param cardList2 :list of cards in hand 2
     * @return the winner or tie result
     */
    private int pairsOrHighRankWinner(ArrayList<Integer> cardList1, ArrayList<Integer> cardList2) {
        int NO_PAIR =0;
        ArrayList<Integer> totalPairsHand1 = totPairsInHand(cardList1);
        ArrayList<Integer> totalPairsHand2 = totPairsInHand(cardList2);
        if (totalPairsHand1.size() == 0 || totalPairsHand2.size() == 0) {
            totalPairsHand1.add(NO_PAIR);
            totalPairsHand2.add(NO_PAIR);
        }
        if (totalPairsHand1.get(0) == NO_PAIR && totalPairsHand2.get(0) == NO_PAIR) {
            int highRankWinner = whoWonHighRank(cardList1, cardList2);
            if (highRankWinner != NO_WINNER) {
                return highRankWinner;
            }
        }
        int sameNumPairs = whoWonPairs(totalPairsHand1, totalPairsHand2);
        if (sameNumPairs != NO_WINNER) {
            return sameNumPairs;
        }
        ArrayList<Integer> rankOfPairsInHand1 = ranksWithPair(cardList1);
        ArrayList<Integer> rankOfPairsInHand2 = ranksWithPair(cardList2);
        int whoWonSamePairs = whoWonHighRank(rankOfPairsInHand1, rankOfPairsInHand2);
        if (whoWonSamePairs != NO_WINNER) {
            return whoWonSamePairs;}
        return whoWonHighRank(cardList1,cardList2);}
    /**
     * Determines a winner on the parameters of higher pair(s)
     * @param totalPairsHand1 : list of number of pairs in hand 1
     * @param totalPairsHand2 :list of number of pairs in hand 2
     * @return the winner or undecided
     */
    private int whoWonPairs(ArrayList<Integer> totalPairsHand1, ArrayList<Integer> totalPairsHand2) {
        if (totalPairsHand1.size() > totalPairsHand2.size() && totalPairsHand1.size() >
                totalPairsHand2.get(0)) {
            return PLAYER1_WON;
        } else if (totalPairsHand1.get(0) > totalPairsHand2.size() && totalPairsHand1.get(0) >
                totalPairsHand2.get(0)) {
            return PLAYER1_WON;
        } else if (totalPairsHand2.size() > totalPairsHand1.size() && totalPairsHand2.size() >
                totalPairsHand1.get(0)) {
            return PLAYER2_WON;
        } else if (totalPairsHand2.get(0) > totalPairsHand1.size() && totalPairsHand2.get(0) >
                totalPairsHand1.get(0)) {
            return PLAYER2_WON;
        } else return NO_WINNER;
    }
    /**
     * Determines the number of pair(s) in each hand
     * @param : list of cards in a hand
     * @return total number of pairs in that hand
     */
    private ArrayList<Integer> totPairsInHand(ArrayList<Integer> cardList) {
        ArrayList<Integer> checkedElements = new ArrayList<Integer>();
        ArrayList<Integer> numPairs = new ArrayList<Integer>();
        for (int rankPos = 0; rankPos < cardList.size(); rankPos++) {
            if (!checkedElements.contains(cardList.get(rankPos))) {
                checkedElements.add(cardList.get(rankPos));
                int frequency = Collections.frequency(cardList, cardList.get(rankPos));
                int NUM_OF_PAIRS = frequency / 2;
                if (NUM_OF_PAIRS> 0) {
                    numPairs.add(NUM_OF_PAIRS);
                }
            }
        }
        return numPairs;
    }
    /**
     * collects the ranks in a hand that have pair as pair or two pairs (if 3 cards of rank only
     gather 2)
     * @param cardList : list of cards in a hand
     * @return the ranks in a hand that have pair
     */
    private ArrayList<Integer> ranksWithPair(ArrayList<Integer> cardList) {
        ArrayList<Integer> numHavePair = new ArrayList<Integer>();
        for (int rankPos = 0; rankPos < cardList.size() ; rankPos++) {
            int frequency = Collections.frequency(cardList, cardList.get(rankPos));
            int NUM_OF_PAIRS = frequency / 2;
            int ADDITIONAL_CARD = frequency % 2;
            if (NUM_OF_PAIRS > 0 && ADDITIONAL_CARD!= 1) {
                numHavePair.add(cardList.get(rankPos));
            }else if (NUM_OF_PAIRS > 0) {
                if ((Collections.frequency(numHavePair, cardList.get(rankPos) )) <= (NUM_OF_PAIRS) *
                        2 ){
                    numHavePair.add(cardList.get(rankPos));
                }
            }
        }
        return numHavePair;
    }
    public String toString(){
        return String.valueOf(cardList);
    }
}