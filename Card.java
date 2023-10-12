/**
 * This class is the framework for a card; it 
 * also contains the public enums for Suit and Rank
 * @author Chloe Schueller
 */

public class Card {
    private Suit suit;
    private Rank rank;
    private boolean turned; //default is false
    //constructor
    public Card(Suit suit, Rank rank, boolean turned) {
        this.suit = suit;
        this.rank = rank;
        this.turned = turned;
    }
    //getters
    public Suit getSuit(){return suit;}
    public Rank getRank(){return rank;}
    public boolean isUp(){return turned;}
    //changing the side facing up on the card
    public void turnDown(){turned=false;}
    public void turnUp(){turned=true;}
    public String displayCard(Card c){
        String s = c.suit.toString()+c.rank.toString();
        return s;
    }
    //checks if the suits are different
    public boolean equalSuit(Card card){
        return suit==card.getSuit();
    }
    //sees if the gard given can be placed
    public boolean nextLower(Card card){
        return this.rank.ordinal()-1 == card.rank.ordinal();
    }
    //sees if they're the same or different color
    public boolean isSameColor(Card card){
        return this.suit.getColor() == card.suit.getColor();
    }
    //see if the card chosen can be placed in the lane
    //see if the card chosen can be placed in the suit
    
    public enum Suit {
        DIAMOND ("♦","red"),
        HEART ("♥︎","red"),
        CLUB ("♣︎","black"),
        SPADE ("♠︎","black");
        
        private String symbol;
        private String color;
        
        Suit (String symbol, String color) {
            this.symbol = symbol;
            this.color = color;
        }
        
        public String getColor () {
            return color;
        }
        
        public String toString () {
            return symbol;
        }
    }

    public enum Rank {
        KING("K "),
        QUEEN("Q "),
        JACK("J "),
        TEN("10"),
        NINE("9 "),
        EIGHT("8 "),
        SEVEN("7 "),
        SIX("6 "),
        FIVE("5 "),
        FOUR("4 "),
        THREE("3 "),
        TWO("2 "),
        ACE("A ");
        
        private String abbrev;
        Rank (String abbrev) {
            this.abbrev = abbrev;
        } 
        public String toString () {
            return abbrev;
        }
    }
    
}