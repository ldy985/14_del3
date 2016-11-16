package Game;

/**
 * Field defines common attribues and methods for all the Field types
 *
 * Bugs: none known
 *
 * @author       Timothy Rasmussen
 * @version      v.0.1
 */
public abstract class Field {

    private String name;
    private final int number;

    public void setName(String newName){name = newName;}

    public String getName() {
        return name;
    }



    /**
     * Constructs a Field
     * @param number the id of the Field
     * @param name The name of the Field
     */
    public Field(int number, String name){

        this.name = name;
        this.number = number;
    }

    /**
     * Handles the stuff that needs to happen when a player lands on a Field
     * @param player The player that lands on the Field
     */
    public abstract void landOnField(Player player);


    //public abstract desktop_fields.Field toGUIField();

    public desktop_fields.Field toGUIField() {
        desktop_fields.Shipping.Builder a = new desktop_fields.Shipping.Builder()
                .setTitle(name)
                .setPicture(null);
        return a.build();
    }


}
