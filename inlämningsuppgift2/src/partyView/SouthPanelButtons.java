/* Namn: Jagtej Sidhu
   ID: al2890
   Program: Systemutvecklare
 */
package partyView;

//import partyModel.ProductType;
import partyController.Controller;
import partyModel.Countries;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SouthPanelButtons extends JPanel
{
    private Controller controller;
    private int width;
    private int height;

    JButton btnOK, btnChange, btnDelete;


    public SouthPanelButtons(Controller controller, int width, int height)
    {
        this.controller = controller;
        this.width = width;
        this.height = height;

        int buttonHeight = height - 4;  //4 = margin
        int buttonWidth = width/6;
/*
        setBorder(BorderFactory.createTitledBorder(""));
        Border border = this.getBorder();
        Border emptyBorder = BorderFactory.createEmptyBorder(4, 4, 4, 4);
        setBorder(new CompoundBorder(border, emptyBorder));

 */
        //GridLayout layout = new GridLayout(2, 1, 2, 2);  //fungerar inte!!
        BorderLayout layout = new BorderLayout();
        setLayout(layout);

       // JPanel pnlRButtons = new JPanel();
        JPanel pnlButtons = new JPanel();

        //pnlButtons.setBorder(BorderFactory.createTitledBorder(""));
        btnOK = new JButton("Add");
        Dimension dim = new Dimension(buttonWidth,buttonHeight);
        btnOK.setSize(dim);

        btnChange = new JButton("Change");
        btnChange.setSize(dim);

        btnDelete = new JButton("Delete");
        btnChange.setSize(dim);

        pnlButtons.add(btnOK);
        pnlButtons.add(btnChange);
        pnlButtons.add(btnDelete);

       // add(pnlRButtons);
        add(pnlButtons);

        addListeners();

    }

    private void addListeners()
    {
        ActionListener listener = new ButtonActionListeners();

        btnOK.addActionListener(listener);
        btnChange.addActionListener(listener);
        btnDelete.addActionListener(listener);
    }

    class ButtonActionListeners implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == btnOK)
                controller.buttonPressed(ButtonType.Add);
            else if (e.getSource()== btnChange)
            {
                controller.buttonPressed(ButtonType.Change);
            }
            else if (e.getSource() == btnDelete)
            {
                controller.buttonPressed(ButtonType.Delete);
            }

        }
    }


}//class
