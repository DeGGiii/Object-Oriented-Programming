/* Namn: Jagtej Sidhu
   ID: al2890
   Program: Systemutvecklare
 */
package view;

import javax.swing.*;

import controller.Controller;

public class MainFrame extends JFrame
{
    private int width = 800;
    private int height = 400;

    Controller controller;
    MainPanel panel;

    public MainFrame(Controller controller)
    {
        this.controller = controller;
        setupFrame();

    }
    //standard settings
    public void setupFrame()
    {
        final int offsetX = width/5;
        final int offsetY = height / 5;

        setSize(width, height);
        setTitle("Pizza Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(offsetX, offsetY);

        panel = new MainPanel(controller, width, height);
        setContentPane(panel);
        setResizable(false);
        pack();

        setVisible(true);
    }

    public void setNumPizza (String str)
    {
        panel.getPnlCenter().setTxtNumPizza(str);
    }

    public void setNumKebab (String text)
    {
        panel.getPnlSouth().setTxtNumKebab(text);
    }

    public void setNumChicken(String text)
    {
        panel.getPnlSouth().setTxtNumChicken(text);
    }

    public void setNumHawaii(String text)
    {
        panel.getPnlSouth().setTxtNumHawaii(text);
    }

    public void setNumCapri(String text)
    {
        panel.getPnlSouth().setTxtNumCapri(text);
    }

    public void setNumMargherita(String text)
    {
        panel.getPnlSouth().setTxtNumMargherita(text);
    }



    /*public Object getPizzaItem()
    {
        return panel.getPnlCenter().getTypeOfPizza();
    }

     */

    /*public void errMessage(String message)
    {
        JOptionPane.showMessageDialog(null, message);
    }

     */
    public void updatePizzaList(String [] stringList)
    {
        panel.getPnlEast().updatePizzaList(stringList);
    }

    /*public int getListIndex()
    {
        return panel.getPnlEast().getListIndex();
    }

     */
    public void showMessage(String message)
    {
        System.out.println(message);
    }

    public void updateSelectedPizza(String[] toppings)
    {
        panel.updateSelectedPizza(toppings);
    }

    public void updateTotalCost(String totalCost)
    {
        panel.getPnlCenter().setTxtTotalCost(totalCost);
    }
}