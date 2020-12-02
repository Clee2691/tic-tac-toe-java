public class Card {
    public Suits suit;
    public Names name;

    
    public enum Suits{
        SPADES,
        HEARTS,
        DIAMONDS,
        CLUBS;
    }

    public enum Names{
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING,
        ACE;
    }

    public Card(Suits suit, Names name){
        this.suit = suit;
        this.name = name;
    }

    public Card(){
        this.suit = null;
        this.name = null;
    }

    public Suits getSuit() {
        return this.suit;
    }

    public void setSuit(Suits suit) {
        this.suit = suit;
    }

    public Names getName() {
        return this.name;
    }

    public void setName(Names name) {
        this.name = name;
    }

    /**
     * getCardIntVal is used for the sortDeck method, in order to assign numeric values to our face enums. Note that this is distinct from the hashmap of values present in Blackjack,
     * as TEN, JACK, QUEEN, and KING all represent a "10" in the game of blackjack. 
     * */
    public int getCardIntVal(){
        if(this.name.toString() == "TWO"){
            return 2;
        } else if(this.name.toString() == "THREE"){
            return 3;
        } else if(this.name.toString() == "FOUR"){
            return 4;
        } else if(this.name.toString() == "FIVE"){
            return 5;
        } else if(this.name.toString() == "SIX"){
            return 6;
        } else if(this.name.toString() == "SEVEN"){
            return 7;
        } else if(this.name.toString() == "EIGHT"){
            return 8;
        } else if(this.name.toString() == "NINE"){
            return 9;
        } else if(this.name.toString() == "ACE"){
            return 14;
        } else if(this.name.toString() == "TEN"){
            return 10;
        } else if(this.name.toString() == "JACK"){
            return 11;
        } else if(this.name.toString() == "QUEEN"){
            return 12;
        } else if(this.name.toString() == "KING"){
            return 13;
        }
        return 0;
    }

    public static void main(String args[]){
        Card c1 = new Card(Suits.SPADES, Names.TWO);
        System.out.println(c1.getName());
    }
    

    
}
