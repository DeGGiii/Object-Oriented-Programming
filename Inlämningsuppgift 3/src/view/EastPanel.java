/* Namn: Jagtej Sidhu
   ID: al2890
   Program: Systemutvecklare
 */
package view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;

import controller.Controller;

public class EastPanel extends JPanel
{
    private JList<String> list;
    private Controller controller;

    public EastPanel(Controller controller, int width, int height, int margin)
    {
        this.controller = controller;

        setBorder(BorderFactory.createTitledBorder("Pizza Register"));

        Border border = this.getBorder();
        Border emptyBorder = BorderFactory.createEmptyBorder(margin, margin, margin, margin);
        setBorder(new CompoundBorder(border, emptyBorder));

        list = new JList(); //data has type Object[]

        Font font = new Font("Courier New", Font.PLAIN, 11);
        list.setFont(font);

        JScrollPane s = new JScrollPane(list);
        //extra saker
        s.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        s.setPreferredSize(new Dimension(width-margin, height-2*margin));

        list.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        add(s);
    }

    public void updatePizzaList(String [] stringList)
    {
        list.setListData(stringList);
    }

}
