public class Card {
    private String suit;
    private int name;

    public Card() {
        suit = null;
        name = 1;
    }

    public Card(String suit, int name) {
        this.suit = suit;
        this.name = name;
    }

    public int getName() {
        return name;
    }

    public String getSuit() {
        return suit;
    }

    public void setName(int name) {
        this.name = name;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String toString() {
        String nameOfCard = "";
        if (name == 1) {
            nameOfCard = "Ace";
        } else if (name >= 2 && name <= 10) {
            nameOfCard = Integer.toString(name);
        } else if (name == 11) {
            nameOfCard = "Jack";
        } else if (name == 12) {
            nameOfCard = "Queen";
        } else if (name == 13) {
            nameOfCard = "King";
        }
        return nameOfCard + " of " + suit;
    }
}