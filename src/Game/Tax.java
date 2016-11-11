package Game;

public class Tax extends Field {

    private int taxAmount;
    private final int taxRate=-1;

    private Tax(int no, String name, int taxAmount){

        this.no=no;
        this.taxAmount=taxAmount;
        this.name=name;
    }

    private int getTaxAmount(){

        return taxAmount;

    }

    private int calculateTax(int totalValue){

        int i=Player.getTotalValue()*(10/100)*taxRate;

        return i;


    }

    public landOnField(){

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