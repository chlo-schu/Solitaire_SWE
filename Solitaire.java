import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solitaire {
    public static final int DECK_SIZE = 52;
    private int score;
    private int numMoves;
    private List<Card> uncoveredPile;
    private List<List<Card>> playingColumns;
    private List<Card> playingDeck;
    public List<List<Card>> suitPiles;
    private static final String[] suits = {"C","D","H","S"};
    private static final String[] vals = {"K","Q","J","10","9","8","7","6","5","4","3","2","A"};
    public static void main(String[] args) {
    }
    public Solitaire() {
        initilizeGame();
        //main game loop
        while(true){
            displayState();
            //ask user input
            var in = new Scanner(System.in);
            System.out.println("Please enter a command");
        }
        //pick a card

        //place card in specified spot
        //move a card from one spot to another
        //show the current cards
    }
    private void initilizeGame(){
        //generate deck
        CardTable currentGame = new CardTable();
        playingColumns = currentGame.playingTable;
        suitPiles = currentGame.suitPiles;
        playingDeck = currentGame.deck;
        //shuffle cards
        Collections.shuffle(playingDeck);
        // place the cards out that are picked for each column
        for(int i=0;i<7;i++){
            for(int j=0;j<i+1;j++){
                playingColumns.get(i).add(playingDeck.remove(0));
            }
        }
        //first uncover
        uncoveredPile.add(playingDeck.remove(0));
        score=0;
        numMoves=0;
    }

    private void displayState(){
        //display uncovered pile
        Card card = uncoveredPile.get(uncoveredPile.size()-1);
        System.out.printf("P:[%s]",displayCard(card));
        System.out.println();

        //display playing columns
        List<Card> playingCol= new ArrayList<>(7);
        for (int i = 0; i < 7; i++) {
            
            for (Card c : playingColumns.get(i)) {
                System.out.print(card + " ");
            }
            System.out.println();
        }

        //display suit piles
        for (int i = 0; i < 4; i++) {
            System.out.print("Suit " + (i + 1) + ": ");
            List<Card> currentSuit = suitPiles.get(i);
            System.out.println();
        }
    }
    private String displayCard(Card c){
        String face = c.getSuit()+c.getValue();
        return face;
    }
}
