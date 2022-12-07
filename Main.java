package proj4;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    /**
     * The following function determines whether the user is correct in choosing the winner of
     pokerHand game.
     */
    public static void main(String[] args) {
        int CARDS_DISTRIBUTED_IN_A_TURN = 4;
        int NUM_COMMUNITY_CARDS = 5;
        int MAX_RANGE_OF_CARDS_USED= 49;
        int totalPoints = 0;
        boolean gameOver = false;
        ArrayList<Card> communityCards = new ArrayList<>();

        Main m = new Main();
        Deck d = new Deck();

        while (d.nextToDeal < NUM_COMMUNITY_CARDS) {
            d.shuffle();
            communityCards.add((d.getCard(d.nextToDeal)));
            d.nextToDeal = d.nextToDeal + 1;
            if (communityCards.size() == NUM_COMMUNITY_CARDS) {
                CommunityCardSet cc = new CommunityCardSet(communityCards);
                while (d.nextToDeal >= NUM_COMMUNITY_CARDS && d.nextToDeal < MAX_RANGE_OF_CARDS_USED
                        && !gameOver) {
                    ArrayList<Card> cardsInHand1 = new ArrayList<>();
                    System.out.println(d);
                    System.out.println(d.nextToDeal);
                    ArrayList<Card> cardsInHand2 = new ArrayList<>();
                    cardsInHand1.add((d.getCard(d.nextToDeal)));
                    cardsInHand2.add((d.getCard(d.nextToDeal + 1)));
                    cardsInHand1.add((d.getCard(d.nextToDeal + 2)));
                    cardsInHand2.add((d.getCard(d.nextToDeal + 3)));
                    System.out.println("\n\nThe community cards are:");
                    System.out.println(cc + "\n");
                    System.out.println("Which of the following hands is worth more?");
                    System.out.println("Hand a:\n" + cardsInHand1 + "\nor");
                    System.out.println("Hand b:\n" + cardsInHand2);
                    d.nextToDeal += CARDS_DISTRIBUTED_IN_A_TURN;
                    StudPokerHand h1 = new StudPokerHand(cc, cardsInHand1);
                    StudPokerHand h2 = new StudPokerHand(cc, cardsInHand2);
                    int winnerHand = h1.compareTo(h2);
                    System.out.print("\nEnter a or b (or 'n' to indicate they are of equal value)");
                    Scanner userInput = new Scanner(System.in);
                    String readInput = userInput.next();

                    String winner = m.whoWon(winnerHand);
                    if (!readInput.equals(winner)) {
                        gameOver = true;
                    }
                    if (!gameOver){
                        totalPoints++;}
                    cardsInHand1.clear();
                    cardsInHand2.clear();
                }
            }
        }
        System.out.println("GAME-OVER");
        System.out.println("YOUR SCORE: " + String.valueOf(totalPoints));
    }

    /**
     * the following method translates the winner so that the users input can be comprehended by the
     IntelliJ
     * @param winnerHand
     * @return the conversion meaning
     */
    private String whoWon(int winnerHand){
        if (winnerHand == 1) {
            return "a";
        }
        else if (winnerHand == -1){
            return "b";
        }
        else return "n";
    }
}

