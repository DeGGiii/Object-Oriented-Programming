/* Namn: Jagtej Sidhu
   ID: al2890
   Program: Systemutvecklare
 */
package view;

import controller.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class MainPanel extends JPanel
{
    private Controller controller;
    private int width;
    private int height;

    private CenterPanel pnlCenter;
    private SouthPanelButtons pnlSouth;

    //JTextArea txtAreaInfo;
    BorderLayout layout;
    EastPanel pnlEast;


    public MainPanel(Controller controller, int width, int height)
    {
        this.controller = controller;
        this.width = width;
        this.height = height;
        setupPanel();
    }

    private void setupPanel()
    {
        layout = new BorderLayout();
        setLayout(layout);

        Border border = this.getBorder();
        Border margin = BorderFactory.createEmptyBorder(6, 6, 6, 6);
        setBorder(new CompoundBorder(border, margin));


        pnlCenter = new CenterPanel(controller,4*width/10, 8*height/10, 6);  //labels and textboxes


        //Buttons at south
        pnlSouth = new SouthPanelButtons(controller, width, 2*height/10);
        add(pnlSouth, layout.SOUTH);

        pnlEast = new EastPanel(controller,6* width/10, 8*height/10, 6);
        add(pnlCenter, layout.CENTER);

        add(pnlEast, BorderLayout.EAST);
    }


    public CenterPanel getPnlCenter()
    {
        return pnlCenter;
    }

    public SouthPanelButtons getPnlSouth()
    {
        return pnlSouth;
    }

    public void updateSelectedPizza(String[] toppings)
    {
        pnlCenter.updateSelectedPizza(toppings);
    }

    public EastPanel getPnlEast() {return  pnlEast;}
    //public int getListIndex(){return pnlEast.getListIndex();}

}
