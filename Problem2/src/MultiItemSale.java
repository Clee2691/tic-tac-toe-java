import java.text.DecimalFormat;

public class MultiItemSale {
    private Sale[] sale;
    private int amountOfArrayUsed;

    public MultiItemSale() {
        sale = new Sale[12];
        amountOfArrayUsed = 0;
    }

    public void addItems(Sale items) {
        if (amountOfArrayUsed < sale.length) {
            sale[amountOfArrayUsed] = items;
            amountOfArrayUsed++;
        }
    }

    public double totalBill() {
        double billTotal = 0.0;
        for (int index = 0; index < amountOfArrayUsed; index++) {
            billTotal = sale[index].bill() + billTotal;
        }
        return billTotal;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");

        return "Total bill= $" + df.format(totalBill());
    }
}
