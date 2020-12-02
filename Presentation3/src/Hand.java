import java.util.ArrayList;
import java.util.Random;

public class Hand {
    private ArrayList<Card> deck = new ArrayList<>();
    private ArrayList<Card> handDeck = new ArrayList<>();
    private static final Card[] hand1 = new Card[5];
    private static final Card[] hand2 = new Card[5];
    private final String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

    public Hand() {
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 14; j++) {
                Card newCard = new Card(suits[i], j);
                deck.add(newCard);
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 6; j++) {
                Card newHandCard = new Card();
            }
        }
    }

    public int getHandSize() {
        return handDeck.size();
    }

    public Card getCardInformation(int position) {
        return handDeck.get(position);
    }

    public void PrintHand() {
        System.out.println(handDeck.toString());
    }

    public void ShuffleHandCards() {
        ArrayList<Card> shuffleHand = new ArrayList<>();
        int index;
        Random randomIndex = new Random();
        do {
            index = randomIndex.nextInt(handDeck.size());
            shuffleHand.add(handDeck.remove(index));
        } while (!handDeck.isEmpty());
        handDeck = shuffleHand;
    }

    public void addHandCard(Card card) {
        handDeck.add(card);
    }

    public void SortHandCards() {
        for (int m = 0; m < (handDeck.size() - 1); m++) {
            int store = m;
            for (int k = (m + 1); k < handDeck.size(); k++) {
                if (handDeck.get(store).getName() > handDeck.get(k).getName())
                    store = k;
            }
            if (store != m) {
                Card sorting = handDeck.remove(store);
                handDeck.add(m, sorting);
                sorting = handDeck.remove(m + 1);
                handDeck.add(sorting);
            }
        }
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        Hand handPlayer1 = new Hand();
        Hand handPlayer2 = new Hand();

        System.out.print("Display every card in deck: \n");
        deck.PrintDeckCards();
        System.out.print("\nShuffle the deck and display the deck: \n");
        deck.ShuffleDeckCards();
        deck.PrintDeckCards();

        System.out.print("\nDisplay Hand 1: \n");
        for (int i = 0; i < 5; i++) {
            hand1[i] = deck.removeDeckCard();
            System.out.print(hand1[i] + ". ");
        }
        System.out.print("\n");

        System.out.print("\nShuffle and display Hand 1: \n");
        for (int i = 0; i < hand1.length; i++) {
            handPlayer1.addHandCard(hand1[i]);
        }
        handPlayer1.ShuffleHandCards();
        handPlayer1.PrintHand();

        System.out.print("\nSort and display Hand 1: \n");
        handPlayer1.SortHandCards();
        handPlayer1.PrintHand();

        System.out.print("\nDisplay Hand 2: \n");
        for (int i = 0; i < hand2.length; i++) {
            hand2[i] = deck.removeDeckCard();
            System.out.print(hand2[i] + ". ");
        }
        System.out.print("\n");

        System.out.print("\nDisplay every card in deck: \n");
        deck.PrintDeckCards();
        System.out.print("\nSort the deck and display the deck: \n");
        deck.SortDeckCards();
        deck.PrintDeckCards();

        System.out.print("\nAdd both hands back to deck, sort the deck, and display the deck: \n");
        for (int i = 0; i < hand2.length; i++) {
            deck.addDeckCard(hand2[i]);
        }
        for (int i = 0; i < hand1.length; i++) {
            deck.addDeckCard(hand1[i]);
        }
        deck.SortDeckCards();
        deck.PrintDeckCards();
    }
}