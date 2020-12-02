import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Deck {
    
    //Initialize Randomizer
    Random rand = new Random();

    //Initialize ArrayList of Cards called Deck
    private ArrayList<Card> deck = new ArrayList<Card>();

    /**
     * 
     * Iterates over each card and suit in order to populate a deck of 52 cards.
     */
    public Deck() {

        for (Card.Suits suit : Card.Suits.values()) {
            for (Card.Names name : Card.Names.values()) {
                Card newCard = new Card(suit, name);
                deck.add(newCard);
            }
        }
    }

    /**
     * printDeck iterates over the deck and prints "FACE" of "SUIT".
     */
    public void printDeck() {
        for (int i = 0; i < deck.size(); i++) {
            System.out.println(deck.get(i).getName() + " of " + deck.get(i).getSuit());
        }
    }

    /**
     * shuffleDeck uses the built in collections method "shuffle" to shuffle the deck of cards.
     */
    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    /**
     * addCard takes one parameter, a card, and appends it to the deck.
     * @param Card
     */
    public void addCard(Card Card) {
        deck.add(Card);
    }

    /**
     * removeCard takes the card at the beggining of the deck and removes/returns it. This will be used to "deal" cards.
     * @return Card
     */
    public Card removeCard() {
        Card output = deck.get(0);
        deck.remove(0);
        return output;
    }

    /**
     * sortCards implements bubble sort to sort the deck of cards by face value.
     */
    public void sortCards(){
        Card temp = new Card();
        for(int j = 0; j < deck.size()-1; j++){
            for(int i = 0; i < deck.size()-j-1; i++){
                if(deck.get(i).getCardIntVal() < deck.get(i+1).getCardIntVal()){
                    temp.setName(deck.get(i).getName());
                    temp.setSuit(deck.get(i).getSuit());
                    deck.get(i).setName(deck.get(i+1).getName());
                    deck.get(i).setSuit(deck.get(i+1).getSuit());
                    deck.get(i+1).setName(temp.getName());
                    deck.get(i+1).setSuit(temp.getSuit());
                }
            }
        }
    }


    public static void main(String args[]){
        Deck deckOfCards = new Deck();
        System.out.println("Deck Pre-Shuffling");
        deckOfCards.printDeck();
        System.out.println(" ");
        System.out.println("Deck Post-Shuffling");
        deckOfCards.shuffleDeck();
        deckOfCards.printDeck();
        System.out.println(" ");
        System.out.println("Deck Post-Sorting");
        deckOfCards.sortCards();
        deckOfCards.printDeck();
        System.out.println(" ");
        System.out.println("Remove Card");
        System.out.println(deckOfCards.removeCard().getName());

    }

}
