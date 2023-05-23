/* Namn: Jagtej Sidhu
   ID: al2890
   Program: Systemutvecklare
 */
package model;

public class PizzaManager
{
    private Pizza[] pizzaList;
    private int currNumOfPizza;
    private int currNumOfKebab = 0;
    private int currNumOfChicken = 0;
    private int currNumOfHawaii = 0;
    private int currNumOfCapricciosa = 0;
    private int currNumOfMargherita = 0;
    private int cost = 0;
    private int totalCost = 0;
    private int id = 0;

    public PizzaManager(int maxElements)
    {
        //skapar array
        pizzaList = new Pizza[maxElements];
    }

    public boolean addItem(Pizza pizza)
    {
        boolean success = true;
        if ( (pizza != null) && (currNumOfPizza < pizzaList.length) )
        {
            pizzaList[currNumOfPizza] = pizza;
            currNumOfPizza++;
            id++;


        }
        else
        {
            success = false;
        }

        return success;
    }

    public void countPizzas(TypeOfPizza countNumPizzas)
    {
        if(countNumPizzas == TypeOfPizza.Kebab)
        {
            cost = 75;
            currNumOfKebab++;
            id++;
        } else if (countNumPizzas == TypeOfPizza.ChickenCurry)
        {
            cost = 75;
            currNumOfChicken++;
            id++;
        } else if (countNumPizzas == TypeOfPizza.Hawaii)
        {
            cost = 75;
            currNumOfHawaii++;
            id++;
        } else if (countNumPizzas == TypeOfPizza.Capricciosa)
        {
            cost = 75;
            currNumOfCapricciosa++;
            id++;
        } else if (countNumPizzas == TypeOfPizza.Margherita)
        {
            cost = 70;
            currNumOfMargherita++;
            id++;
        }

    }


    public String [] getPizzaInfoStrings()
    {
        int id = 0;
        String [] infoString = new String[currNumOfPizza];
        for(int i = 0; i < currNumOfPizza; i++){
            if (pizzaList[i] != null) {
                infoString[i] = pizzaList[i].toString();
                id++;
            } else {
                break;
            }
        }
        return infoString;
    }

    public int getNumOfPizza() {
        return currNumOfPizza;
    }

    public int getNumOfKebab()
    {
        return currNumOfKebab;
    }

    public int getNumOfChicken()
    {
        return currNumOfChicken;
    }

    public int getNumOfHawaii()
    {
        return currNumOfHawaii;
    }

    public int getNumOfCapricciosa()
    {
        return currNumOfCapricciosa;
    }

    public int getNumOfMargherita()
    {
        return currNumOfMargherita;
    }

    public int getCost()
    {
        totalCost = totalCost + cost;
        return totalCost;
    }

}
