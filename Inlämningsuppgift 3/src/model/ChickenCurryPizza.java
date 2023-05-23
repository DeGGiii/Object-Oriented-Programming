/* Namn: Jagtej Sidhu
   ID: al2890
   Program: Systemutvecklare
 */
package model;

public class ChickenCurryPizza extends Pizza
{
    public ChickenCurryPizza()
    {
        super(2, 75, new String[]{"Chicken", "Curry", "Mozzarella Cheese", "Tomato Sauce", "Peanuts", "Banana"});
    }

    public TypeOfPizza getTypeOfPizza()
    {
        return TypeOfPizza.ChickenCurry;
    }

    @Override
    public String toString() {
        return String.format("%s |  %s ", getTypeOfPizza(), super.toString());
    }
}
