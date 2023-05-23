/* Namn: Jagtej Sidhu
   ID: al2890
   Program: Systemutvecklare
 */
package controller;

import model.*;
import view.ButtonType;
import view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener
{
    MainFrame view;
    PizzaManager register;
    TypeOfPizza typeOfPizza;
    TypeOfPizza selectedPizza;

    //constructor
    public Controller(int maxNbrOfPizza)
    {
        register = new PizzaManager(maxNbrOfPizza);
        view = new MainFrame(this);
        view.updatePizzaList(register.getPizzaInfoStrings());
    }

    //Denna metod anropas av view
    // Här inne räknar den även upp totala antalet pizzor och var o en pizza typ.
    public void buttonPressed(ButtonType button)
    {
        Pizza pizza = null;
        switch (button)
        {
            case Order:
                if(validateSelectedPizza(selectedPizza))
                {
                    pizza = createPizza(selectedPizza);
                    register.countPizzas(selectedPizza);
                    register.addItem(pizza);
                    break;
                }

            default:
                view.showMessage("Inte färdigt!");
                break;

        }

        int kebabCount = register.getNumOfKebab();
        view.setNumKebab(Integer.toString(kebabCount));

        int ChickenCount = register.getNumOfChicken();
        view.setNumChicken(Integer.toString(ChickenCount));

        int HawaiiCount = register.getNumOfHawaii();
        view.setNumHawaii(Integer.toString(HawaiiCount));

        int CapriCount = register.getNumOfCapricciosa();
        view.setNumCapri(Integer.toString(CapriCount));

        int MargheritaCount = register.getNumOfMargherita();
        view.setNumMargherita(Integer.toString(MargheritaCount));

        int attendance = register.getNumOfPizza();
        view.setNumPizza(Integer.toString(attendance));

        int totalCost = register.getCost();
        view.updateTotalCost(Integer.toString(totalCost));

        view.updatePizzaList(register.getPizzaInfoStrings());
    }

    //Kollar ifall selectedPizza är null eller ej. Är det null så får man upp ett meddelande som säger att det är lika med null.
    private boolean validateSelectedPizza(TypeOfPizza selectedPizza){
        boolean ok= true;
        if(selectedPizza == null){
            JOptionPane.showMessageDialog(null, "ERROR! Please select a pizza from the list.");
            ok = false;
        }
        return ok;
    }

    //Här skapas de olika pizzorna beroende på den selectedPizza. När en viss pizza är vald så skapas ett objekt av den klassen som tillhör den pizzan.
    public Pizza createPizza(TypeOfPizza selectedPizza)
    {
        switch (selectedPizza)
        {
            case None:
                JOptionPane.showMessageDialog(null, "ERROR! Please select a pizza from the list.");
                break;

            case Kebab:
                return new KebabPizza();

            case ChickenCurry:
                return new ChickenCurryPizza();

            case Hawaii:
                return new HawaiiPizza();

            case Capricciosa:
                return new CapricciosaPizza();

            case Margherita:
                return new MargheritaPizza();
        }
        return null;
    }

    //Metoden kollar om efter den valda pizzan i en JComboBox som ligger i CenterPanel.
    // När en pizza är vald så anropas enumet för den pizzan samt ett objekt skapas
    // och getToppings metoden anropas från superklassen och skickar vidare det till
    // centerpanel genom mainframe och mainpanel
    public Pizza handleSelectedPizza(TypeOfPizza selectedPizza)
    {
        Pizza pizza = null;
        this.selectedPizza = selectedPizza;

        switch (selectedPizza)
        {
            case Kebab:
                typeOfPizza = TypeOfPizza.Kebab;
                pizza = new KebabPizza();
                view.updateSelectedPizza(pizza.getToppings());
                break;

            case ChickenCurry:
                typeOfPizza = TypeOfPizza.ChickenCurry;
                pizza = new ChickenCurryPizza();
                view.updateSelectedPizza(pizza.getToppings());
                break;

            case Hawaii:
                typeOfPizza = TypeOfPizza.Hawaii;
                pizza = new HawaiiPizza();
                view.updateSelectedPizza(pizza.getToppings());
                break;

            case Capricciosa:
                typeOfPizza = TypeOfPizza.Capricciosa;
                pizza = new CapricciosaPizza();
                view.updateSelectedPizza(pizza.getToppings());
                break;

            case Margherita:
                typeOfPizza = TypeOfPizza.Margherita;
                pizza = new MargheritaPizza();
                view.updateSelectedPizza(pizza.getToppings());
                break;

            default:
                System.out.println("Error occured!");
                break;

        }
        return pizza;
    }

    //I denna metod så skapar man en variabel som castar först jcombobox och därefter TypeOfPizza.
    //Här kollar den vilken pizza som är vald i JComboBoxen för programmet med alla pizzor och sedan skickar vidare detta till
    //handleSelectedPizza metoden.
    public void actionPerformed(ActionEvent e) {

        var jComboBox = (JComboBox) e.getSource();
        if (jComboBox == null)
        {
            System.out.println("JComboBox is null!");
            return;
        }

        var choice = (TypeOfPizza) jComboBox.getSelectedItem();
        if(choice == null)
        {
            System.out.println("Choice is null");
        }
        handleSelectedPizza(choice);
    }

    //Här skapas en metod som kallar på värden i vårt enum som lagras i en TypeOfPizza array
    public TypeOfPizza [] getPizzaItems()
    {
        return TypeOfPizza.values();
    }


}
