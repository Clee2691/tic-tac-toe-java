import java.util.ArrayList;
import java.util.Collections;


public class Hand extends Deck {

    private ArrayList<Card> hand;

    public Hand(){
        this.hand = new ArrayList<Card>();
    }

    public void shuffleHand(){
        Collections.shuffle(this.hand);
    }

    public void printHand(){
        for (int i = 0; i < this.hand.size(); i++){
            System.out.println(this.hand.get(i).getName() + " of " + this.hand.get(i).getSuit());
        }
    }

    public void add(Card Card){
        this.hand.add(Card);
    }

    //Remove Card
    public Card removeCard(){
        Card output = this.hand.get(0);
        this.hand.remove(0);
        return output;
    }

    public void showCard(){
        System.out.println(hand.get(0).getName() + " of " + hand.get(0).getSuit());
    }

    public int getSize(){
        return this.hand.size();
    }

    public Card.Names getCardValue(int index){
        return this.hand.get(index).getName();
    }

    


    public static void main(String args[]){
       
        

        
    }
}
