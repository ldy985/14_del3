package Game;

import desktop_resources.GUI;
import static Game.Language.getString;

/**
 * Keeps track of the balance, and adds/subtracts by the points on the board.
 *
 * Bugs: none known
 *
 * @author       Casper Bodskov
 * @version      v.0.1
 */

public class Tax extends Field {

    private final int taxAmount;
    private float taxRate;

    /**
     * @param no        The field number
     * @param name      The name of the Field
     * @param taxAmount The permanent tax on the Field
     */
    public Tax(int no, String name, int taxAmount, float taxRate) {
        super(no, name);
        this.taxAmount = taxAmount;
        this.taxRate = taxRate;
    }

    /**
     * Gets the permanent amount of tax the player needs to pay
     */
    public int getTaxAmount() {

        return taxAmount;

    }

    /**
     * Calculates the tax the player needs to pay
     *
     * @param totalValue The total value of the player
     * @return The amount of money the player needs to pay
     */
    private int calculateTax(int totalValue) {

        return (int) (totalValue * taxRate);
    }

    /**
     * Handles the stuff that needs to happen when a player lands on a field
     *
     * @param player The player that lands on the field
     */
    public void landOnField(Player player) {


        int calculatedTax = calculateTax(player.getRealEstateValue()+player.getAccount().getBalance());
        if (taxRate != 1.0f && InterfaceController.getUserSelection((getString("paytax1") + taxAmount + getString("paytax2") + "10% ( " + calculatedTax + ")"), taxAmount + "", "10%") == "10%") {
            player.getAccount().addBalance(calculatedTax);

        } else {
            player.getAccount().addBalance(-taxAmount);
        }

        GUI.showMessage(getString("landed") + getName());
        InterfaceController.showMessage(getString("landed") + getName());

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