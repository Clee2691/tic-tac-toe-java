public class Problem2Main {
    public static void main(String[] args) {
        System.out.println("Sale at Grocery Store!");
        Sale item1 = new Sale("Apple", 1.25);
        System.out.println(item1);
        Sale item2 = new Sale("Orange", 0.99);
        System.out.println(item2);

        DiscountSale item3 = new DiscountSale("Raspberries", 3.00, 50);
        System.out.println(item3);
        DiscountSale item4 = new DiscountSale("Blueberries", 10.00, 25);
        System.out.println(item4);

        MultiItemSale listOfItems = new MultiItemSale();
        listOfItems.addItems(item1);
        listOfItems.addItems(item2);
        listOfItems.addItems(item3);
        listOfItems.addItems(item4);

        System.out.print("\n" + listOfItems);
    }
}