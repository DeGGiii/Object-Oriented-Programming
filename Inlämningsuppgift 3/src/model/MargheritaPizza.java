/* Namn: Jagtej Sidhu
   ID: al2890
   Program: Systemutvecklare
 */
package model;

public class MargheritaPizza extends Pizza
{
    public MargheritaPizza()
    {
        super(4, 70, new String[]{"Tomato sauce", "Mozzarella cheese"});
    }

    public TypeOfPizza getTypeOfPizza()
    {
        return TypeOfPizza.Margherita;
    }

    @Override
    public String toString() {
        return String.format("%s   |  %s ", getTypeOfPizza(), super.toString());
    }
}
