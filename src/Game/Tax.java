package Game;

public class Tax extends Field {

    private int taxAmount;
    private final int taxRate = -1;

    private Tax(int no, String name, int taxAmount) {
        super(name, no);
        this.taxAmount = taxAmount;
    }

    private int getTaxAmount() {

        return taxAmount;

    }

    private int calculateTax(int totalValue) {

        return totalValue * (10 / 100) * taxRate;
    }

    public void landOnField(Player player) {

    }
}



/* Percent tax calculation
int tax = (int) value*(10.0f/100.0f)
where 10.0f is the percentage, value is the amount of points the player has
and tax is the final calculated tax.
Then
taxRate = -1
taxRate*tax= finalTaxation
- that with the player's points either here or in another class. (eg. account)
 */