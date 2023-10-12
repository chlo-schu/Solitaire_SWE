import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class CardTable {
    public List<List<Card>> playingTable;
    public Stack<Card> deck;
    public List<List<Card>> suitPiles;
    
    public CardTable(){
        genDeck();
        playingTable = new ArrayList<>(7);
        //fills the lanes and turns up the last card in each lane
        for(int i=0;i<7;i++){ 
            playingTable.add(new ArrayList<>());
            for(int j=0;j<i;j++){
                Card current = deck.pop();
                if(j==i-- || j==0 & i==0){
                    current.turnUp();
                }
                playingTable.get(i).add(current);
            }
        }
        //creates the suit piles
        for(int j=0;j<4;j++){
            suitPiles.add(new ArrayList<>());
        }
        
    }
    //generates the deck upon making the table
    public Stack<Card> genDeck(){
        deck = new Stack<>();
        for(Rank i:Rank.values()) {
            for (Suit j : Suit.values()) {
                deck.push(new Card(i, j));
            }
        }
        return deck;
    }
}
