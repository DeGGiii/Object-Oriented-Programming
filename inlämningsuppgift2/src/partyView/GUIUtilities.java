/* Namn: Jagtej Sidhu
   ID: al2890
   Program: Systemutvecklare
 */
package partyView;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class GUIUtilities
{
    //set border for any panel
    public static void setPanelBorder(JPanel panel, String titel, int margin)
    {
        panel.setBorder(BorderFactory.createTitledBorder(titel));
        Border border = panel.getBorder();
        Border emptyBorder = BorderFactory.createEmptyBorder(margin, margin, margin, margin);
        panel.setBorder(new CompoundBorder(border, emptyBorder));

    }

    public static JScrollPane setListScrollPanes(JList list, int width, int height)
    {
        JScrollPane s = new JScrollPane(list);
        //extra saker
        s.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        int margin = 24;
        s.setPreferredSize(new Dimension(width-margin, height-2*margin));
        list.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);

        Font font = new Font("Arial", Font.PLAIN, 14);
        list.setFont(font);

        return s;
    }

}