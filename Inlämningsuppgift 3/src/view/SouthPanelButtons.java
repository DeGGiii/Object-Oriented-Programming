/* Namn: Jagtej Sidhu
   ID: al2890
   Program: Systemutvecklare
 */
package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SouthPanelButtons extends JPanel
{
    private Controller controller;
    private int width;
    private int height;

    JButton btnOrder;

    JLabel numKebab, numChicken, numHawaii, numCapricciosa, numMargherita;

    JLabel txtKebab, txtChicken, txtHawaii, txtCapricciosa, txtMargherita;




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
        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        JPanel pnlButtons = new JPanel();

        btnOrder = new JButton("Order");
        Dimension dim = new Dimension(buttonWidth,buttonHeight);
        btnOrder.setSize(dim);

        // Antalet för varje pizza som ökas
        numKebab = new JLabel("0");
        numKebab.setSize(dim);

        numChicken = new JLabel("0");
        numKebab.setSize(dim);

        numHawaii = new JLabel("0");
        numHawaii.setSize(dim);

        numCapricciosa = new JLabel("0");
        numCapricciosa.setSize(dim);

        numMargherita = new JLabel("0");
        numMargherita.setSize(dim);

        //Namn på varje pizza som ligger bredvid ökningen
        txtKebab = new JLabel("Kebab (75 SEK): ");
        txtKebab.setSize(dim);

        txtChicken = new JLabel("| Chicken (75 SEK): ");
        txtChicken.setSize(dim);

        txtHawaii = new JLabel("| Hawaii (75 SEK): ");
        txtHawaii.setSize(dim);

        txtCapricciosa = new JLabel("| Capricciosa (75 SEK): ");
        txtCapricciosa.setSize(dim);

        txtMargherita = new JLabel("| Margherita (70 SEK): ");
        txtMargherita.setSize(dim);

        pnlButtons.add(txtKebab);
        pnlButtons.add(numKebab);

        pnlButtons.add(txtChicken);
        pnlButtons.add(numChicken);

        pnlButtons.add(txtHawaii);
        pnlButtons.add(numHawaii);

        pnlButtons.add(txtMargherita);
        pnlButtons.add(numMargherita);

        pnlButtons.add(txtCapricciosa);
        pnlButtons.add(numCapricciosa);

        pnlButtons.add(btnOrder);

        add(pnlButtons);
        addListeners();

    }

    private void addListeners()
    {
        ActionListener listener = new ButtonActionListeners();

        btnOrder.addActionListener(listener);
    }

    class ButtonActionListeners implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == btnOrder)
            {
                controller.buttonPressed(ButtonType.Order);
            }
        }
    }

    public void setTxtNumKebab(String text)
    {
        numKebab.setText(text);
    }

    public void setTxtNumChicken(String text)
    {
        numChicken.setText(text);
    }

    public void setTxtNumHawaii(String text)
    {
        numHawaii.setText(text);
    }

    public void setTxtNumCapri(String text)
    {
        numCapricciosa.setText(text);
    }

    public void setTxtNumMargherita(String text)
    {
        numMargherita.setText(text);
    }


}//class
