/* Namn: Jagtej Sidhu
   ID: al2890
   Program: Systemutvecklare
 */
package model;

public class CapricciosaPizza extends Pizza
{
    public CapricciosaPizza()
    {
        super(5, 75, new String[]{"Ham", "Mozzarella Cheese", "Tomato Sauce", "Mushrooms"});
    }

    public TypeOfPizza getTypeOfPizza()
    {
        return TypeOfPizza.Capricciosa;
    }

    @Override
    public String toString() {
        return String.format("%s  |  %s ", getTypeOfPizza(), super.toString());
    }
}
