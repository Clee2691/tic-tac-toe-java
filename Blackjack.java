import java.util.Scanner;

public class Blackjack extends Hand {

    //method that returns the value of the player's cards
    public int cardValue() {
        int numberOfCards = getHandSize(), acePresent = 0, cardTotalSum = 0;

        //runs loop to get value of each card and adds to total card value
        for (int i = 0; i < numberOfCards; i++) {
            Card card = getCardInformation(i);
            int cardName = card.getName(); //obtains card value
            if (cardName >= 10) { //if 10, Jack, Queen, King then value is 10
                cardName = 10;
            }
            if (cardName == 1) { //if Ace the value is 1
                acePresent = 1; //keeps track of ace presence
            }
            cardTotalSum = cardTotalSum + cardName;
        }
        if (acePresent == 1 && (cardTotalSum + 10) <= 21) { //checks if Ace can be valued to 11
            cardTotalSum = cardTotalSum + 10;
        }
        return cardTotalSum;
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        Blackjack user = new Blackjack();
        Blackjack dealer = new Blackjack();

        System.out.println("Lets play blackjack!\n");
        deck.ShuffleDeckCards();

        user.addHandCard(deck.removeDeckCard()); //adds first 2 cards in deck to user
        user.addHandCard(deck.removeDeckCard());
        dealer.addHandCard(deck.removeDeckCard()); //adds next 2 cards in deck to dealer
        dealer.addHandCard(deck.removeDeckCard());

        //users turn
        do { //loop till users total card value is less than 21
            if (user.cardValue() == 21) { //checks users win condition
                System.out.print("User these are your cards: ");
                user.PrintHand();
                System.out.print("User your current score is: ");
                System.out.println(user.cardValue());
                System.out.println("User Wins!");
                break;
            } else if (dealer.cardValue() == 21) { //checks dealers win condition
                System.out.print("Dealer these are your cards: ");
                user.PrintHand();
                System.out.print("Dealer your current score is: ");
                System.out.println(user.cardValue());
                System.out.println("Dealer Wins!");
                break;
            } else {
                System.out.print("User these are your cards: ");
                user.PrintHand();
                System.out.print("User your current score is: ");
                System.out.println(user.cardValue());
                System.out.print("Dealers card is: ");
                System.out.print(dealer.getCardInformation(0) + "\n"); //only displays 1 of dealers cards
                String userInput;
                Scanner input = new Scanner(System.in);
                System.out.print("Would you like to hit (y or n)? ");
                userInput = input.next();

                if (userInput.equals("y")) {
                    user.addHandCard(deck.removeDeckCard());
                } else {
                    System.out.print("\n");
                    break;
                }
            }
        } while (user.cardValue() <= 21);

        if (user.cardValue() > 21) { //checks users losing condition (after users turn, card score>21)
            System.out.print("User these are your cards: ");
            user.PrintHand();
            System.out.print("User your current score is: ");
            System.out.println(user.cardValue());
            System.out.println("Sorry user you lost!");
        }
        if (user.cardValue() == 21) { //checks users win condition
            System.out.println("User you won!");
        }

        //dealers turn
        while (dealer.cardValue() < 21 && user.cardValue() < 21) { //loops while user and dealer cards <21
            System.out.print("Dealer these are your cards: ");
            dealer.PrintHand();
            System.out.print("Dealer your current score is: ");
            System.out.println(dealer.cardValue());
            if (dealer.cardValue() >= 17 && dealer.cardValue() < 21) {//dealer only hits if value <17
                break;
            }
            System.out.print("Dealer is hitting. ");
            dealer.addHandCard(deck.removeDeckCard());

            if (dealer.cardValue() == 21) {//checks dealers win condition
                System.out.println("Dealer you won!");
                break;
            }
            if (dealer.cardValue() > 21) {//checks dealers losing condition
                System.out.print("Dealer these are your cards: ");
                dealer.PrintHand();
                System.out.print("Dealer your current score is: ");
                System.out.println(dealer.cardValue());
                System.out.println("Sorry dealer you lost!");
                break;
            }
        }

        if (user.cardValue() == dealer.cardValue() && user.cardValue() < 21 && dealer.cardValue() < 21) {//checks for a tie
            System.out.println("Its a tie!");
        } else if (user.cardValue() > dealer.cardValue() && user.cardValue() < 21 && dealer.cardValue() < 21) {//if neither reach 21, checks who is closer to 21 to declare winner
            System.out.println("User you won!");
        } else if (user.cardValue() < dealer.cardValue() && user.cardValue() < 21 && dealer.cardValue() < 21) {
            System.out.println("Dealer you won!");
        }
    }
}