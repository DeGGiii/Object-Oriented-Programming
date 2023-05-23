/* Namn: Jagtej Sidhu
   ID: al2890
   Program: Systemutvecklare
 */
package partyView;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import partyController.Controller;

public class EastPanelGuestList extends JPanel
{
    private JList<String> list;
    private Controller controller;

    public EastPanelGuestList(Controller controller, int width, int height, int margin)
    {
        this.controller = controller;

        setBorder(BorderFactory.createTitledBorder("Guest Register"));

        Border border = this.getBorder();
        Border emptyBorder = BorderFactory.createEmptyBorder(margin, margin, margin, margin);
        setBorder(new CompoundBorder(border, emptyBorder));

        //String[] data = addTestValue();
        list = new JList(); //data has type Object[]

        Font font = new Font("Courier New", Font.PLAIN, 11);
        list.setFont(font);

        JScrollPane s = new JScrollPane(list);
        //extra saker
        s.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        s.setPreferredSize(new Dimension(width-margin, height-2*margin));

        list.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        addListener();
        add(s);
     }

    public int getListIndex()
    {
        return list.getSelectedIndex();
    }

    public void updateGuestList(String [] stringList)
    {
        list.setListData(stringList);
    }

    public void addListener()
    {
        list.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent evt)
            {
                //int index = evt.getFirstIndex();
                int index = list.getSelectedIndex();
                if ( index > -1)
                {
                    controller.guestLisIndexChanged(index);
                }
            }});
    }


}
