/* Namn: Jagtej Sidhu
   ID: al2890
   Program: Systemutvecklare
 */
package model;

public class KebabPizza extends Pizza
{
    public KebabPizza()
    {
        super(1, 75, new String[]{"Kebab", "Mozzarella Cheese", "Tomato sauce", "Garlic sauce"});
    }

    public TypeOfPizza getTypeOfPizza()
    {
        return TypeOfPizza.Kebab;
    }

    @Override
    public String toString() {
        return String.format("%s        |  %s ", getTypeOfPizza(), super.toString());
    }
}
