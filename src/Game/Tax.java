package Game;

public class Tax {

    private int taxAmount;
    private int taxRate=-1;

    private Tax(int no, String name, int taxAmount){

        new Tax(1, "Caravan",taxAmount);
        new Tax(2, "Goldmine",taxAmount);

    }

    private getTaxAmount();{

        if (int no=1){

            taxAmount = calculateTax()*taxRate;

        }
        else
        {
            taxAmount = 2000;
        }

    }

    private int calculateTax(int totalValue){

        int taxBeforeRate = totalValue*(10/100);
        return taxBeforeRate;

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