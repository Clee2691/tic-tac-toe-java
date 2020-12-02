public class CardDeckHandDriver {
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
        //
        deckOfCards.shuffleDeck();
        Hand one = new Hand();
        Hand two = new Hand();
        //Deal 5 Cards to Each Hand
        one.add(deckOfCards.removeCard());
        two.add(deckOfCards.removeCard());
        one.add(deckOfCards.removeCard());
        two.add(deckOfCards.removeCard());
        one.add(deckOfCards.removeCard());
        two.add(deckOfCards.removeCard());
        one.add(deckOfCards.removeCard());
        two.add(deckOfCards.removeCard());
        one.add(deckOfCards.removeCard());
        two.add(deckOfCards.removeCard());

        System.out.println(" ");
        System.out.println("Hand One");
        one.printHand();
        System.out.println(" ");
        System.out.println("Hand Two");
        two.printHand();

        System.out.println(" ");
        System.out.println("Post-Dealing Deck");
        deckOfCards.sortCards();
        deckOfCards.printDeck();
        
        deckOfCards.addCard(one.removeCard());
        deckOfCards.addCard(one.removeCard());
        deckOfCards.addCard(one.removeCard());
        deckOfCards.addCard(one.removeCard());
        deckOfCards.addCard(one.removeCard());
        deckOfCards.addCard(two.removeCard());
        deckOfCards.addCard(two.removeCard());
        deckOfCards.addCard(two.removeCard());
        deckOfCards.addCard(two.removeCard());
        deckOfCards.addCard(two.removeCard());

        System.out.println(" ");
        System.out.println("Final Deck");
        deckOfCards.sortCards();
        deckOfCards.printDeck();
    }
}
