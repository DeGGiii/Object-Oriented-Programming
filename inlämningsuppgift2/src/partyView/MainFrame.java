/* Namn: Jagtej Sidhu
   ID: al2890
   Program: Systemutvecklare
 */
package partyView;

import javax.swing.*;

import partyController.Controller;

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
        setTitle("Party Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(offsetX, offsetY);

        panel = new MainPanel(controller, width, height);
        setContentPane(panel);
        setResizable(false);
        pack();

        setVisible(true);
    }

    public String getFirstNameText ()
    {
        return panel.getPnlCenter().getFirstNameText();
    }
    public void setFirstNameText (String str)
    {
        panel.getPnlCenter().setFirstNameText(str);
    }

    public String getLastText ()
    {
        return panel.getPnlCenter().getLastNameText();
    }
    public void setLastNameText (String str)
    {
        panel.getPnlCenter().setLastNameText(str);
    }

    public String getStreetText ()
    {
        return panel.getPnlCenter().getStreetText();
    }
    public void setStreetText (String str)
    {
        panel.getPnlCenter().setStreetText(str);
    }
    public String getCityText ()
    {
        return panel.getPnlCenter().getCityText();
    }
    public void setCityText (String str)
    {
        panel.getPnlCenter().setCityText(str);
    }
    public String getZipCodeText ()
    {
        return panel.getPnlCenter().getZipCodeText();
    }
    public void setZipCodeText (String str)
    {
        panel.getPnlCenter().setZipCodeText(str);
    }
    public void setNumGuest (String str)
    {
        panel.getPnlCenter().setTxtNumGuest(str);
    }

    public Object getCountriesItem(){return panel.getPnlCenter().getCountriesItem();}
   // public Countries getProductTyp(){return panel.getPnlSouth().getProductType();}

    //public void setProductType(Countries country){panel.getPnlSouth().setProductType(productType);}


    public void errMessage(String message)
    {
        JOptionPane.showMessageDialog(null, message);
    }
    public void updateGuestList(String [] stringList)
    {
        panel.getPnlEast().updateGuestList(stringList);
    }
    public int getListIndex()
    {
        return panel.getPnlEast().getListIndex();
    }
}
