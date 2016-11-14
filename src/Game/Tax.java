package Game;

import desktop_resources.GUI;

/**
 * A field of the Type Tax
 */
public class Tax extends Field {

    private final int taxAmount;
    private float taxRate;

    /**
     * @param no        The field number
     * @param name      The name of the Field
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
     *
     * @param totalValue The total value of the player
     * @return The amount of money the player needs to pay
     */
    private int calculateTax(int totalValue) {

        return (int) (totalValue * taxRate); // TODO: 11-11-2016 talk about rounding
    }

    /**
     * Handles the stuff that needs to happen when a player lands on a field
     *
     * @param player The player that lands on the field
     */
    public void landOnField(Player player) {


        int calculatedTax = calculateTax(player.getRealEstateValue()+player.getAccount().getBalance());
        if (taxRate != 1.0f && GUI.getUserSelection(("Do you want to pay " + taxAmount + "or 10% (" + calculatedTax + ")"), taxAmount + "", "10%") == "10%") {
            player.getAccount().addBalance(calculatedTax);

        } else {
            player.getAccount().addBalance(-taxAmount);
        }

        GUI.showMessage("You landed on " + getName());

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