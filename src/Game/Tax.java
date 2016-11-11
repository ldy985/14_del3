package Game;

/**
 * A field of the Type Tax
 */
public class Tax extends Field {

    private int taxAmount;
    private final int taxRate = -1;

    /**
     *
     * @param no The field number
     * @param name The name of the Field
     * @param taxAmount The permanent tax on the Field
     */
    private Tax(int no, String name, int taxAmount) {
        super(no, name);
        this.taxAmount = taxAmount;
    }

    /**
     * Gets the permanent amount of tax the player needs to pay
     */
    private int getTaxAmount() {

        return taxAmount;

    }

    /**
     * Calculates the tax the player needs to pay
     * @param totalValue The total value of the player
     * @return The amount of money the player needs to pay
     */
    private int calculateTax(int totalValue) {

        return totalValue * (10 / 100) * taxRate;
    }

    /**
     * Handles the stuff that needs to happen when a player lands on a field
     * @param player The player that lands on the field
     */
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