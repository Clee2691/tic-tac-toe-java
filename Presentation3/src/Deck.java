import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> deck = new ArrayList<>();
    private final String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

    public Deck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 14; j++) {
                Card newCard = new Card(suits[i], j);
                deck.add(newCard);
            }
        }
    }

    public void PrintDeckCards() {
        System.out.println(deck.toString());
    }

    public void ShuffleDeckCards() {
        ArrayList<Card> shuffleDeck = new ArrayList<>();
        int index;
        Random randomIndex = new Random();
        do {
            index = randomIndex.nextInt(deck.size());
            shuffleDeck.add(deck.remove(index));
        } while (!deck.isEmpty());
        deck = shuffleDeck;
    }

    public void addDeckCard(Card card) {
        deck.add(card);
    }

    public Card removeDeckCard() {
        return deck.remove(0);
    }

    public void SortDeckCards() {
        for (int i = 0; i < (deck.size() - 1); i++) {
            int store = i;
            for (int k = (i + 1); k < deck.size(); k++) {
                if (deck.get(store).getName() > deck.get(k).getName())
                    store = k;
            }
            if (store != i) {
                Card sorting = deck.remove(store);
                deck.add(i, sorting);
                sorting = deck.remove(i + 1);
                deck.add(sorting);
            }
        }
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        Card card;
        System.out.print("Display every card in deck: \n");
        deck.PrintDeckCards();
        System.out.print("\nShuffle the deck and display the deck: \n");
        deck.ShuffleDeckCards();
        deck.PrintDeckCards();
        System.out.print("\nRemove the first card in the deck and display the card: \n");
        card = deck.removeDeckCard();
        System.out.println(card);
        System.out.print("\nAdd the first card back in the deck and display the deck: \n");
        deck.addDeckCard(card);
        deck.PrintDeckCards();
        System.out.print("\nSort the deck and display the deck: \n");
        deck.SortDeckCards();
        deck.PrintDeckCards();
    }
}