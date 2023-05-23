/* Namn: Jagtej Sidhu
   ID: al2890
   Program: Systemutvecklare
 */
package model;

public class HawaiiPizza extends Pizza
{
    public HawaiiPizza()
    {
        super(3, 75, new String[]{"Ham", "Mozzarella Cheese", "Tomato sauce", "Pineapple"});
    }

    public TypeOfPizza getTypeOfPizza()
    {
        return TypeOfPizza.Hawaii;
    }

    @Override
    public String toString() {
        return String.format("%s       |  %s ", getTypeOfPizza(), super.toString());
    }
}
