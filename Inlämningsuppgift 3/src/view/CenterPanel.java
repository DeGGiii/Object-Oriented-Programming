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


public class CenterPanel extends JPanel {
    private int width;
    private int height;
    private int maxToppings = 6;

    private JLabel lblText;
    private JLabel lblCost;
    private JLabel[] lblToppings;
    private JLabel txtNumPizza;
    private JLabel txtTotalCost;

    private JComboBox cmbPizzas;

    private JPanel pnlLeft;  //for labels at left
    private JPanel pnlRight; //for textboxes at right

    private Controller controller;

    public CenterPanel(Controller controller, int width, int height, int margin)
    {
        this.controller = controller;
        this.width = width;
        this.height = height;

        setBorder(BorderFactory.createTitledBorder("Pizza information"));

        Border border = this.getBorder();
        Border emptyBorder = BorderFactory.createEmptyBorder(margin, margin, margin, margin);
        setBorder(new CompoundBorder(border, emptyBorder));

        setLayout(new BorderLayout());

        setPreferredSize(new Dimension(width,height));
        CreateComponents();
    }


    private void CreateComponents()
    {
        createComponentsOnLeftPanel();
        createVariablesOnRightPanel();
    }

    private void createComponentsOnLeftPanel()
    {

        GridLayout layoutLeft = new GridLayout(10, 1, 2, 2);
        Dimension dim = new Dimension(4*width / 10, height);

        JLabel blank  = new JLabel("");
        JLabel blank1  = new JLabel("");
        JLabel lblTopping1  = new JLabel("Topping 1:");
        JLabel lblTopping2 = new JLabel("Topping 2:");
        JLabel lblTopping3 = new JLabel("Topping 3:");
        JLabel lblTopping4  = new JLabel("Topping 4:");
        JLabel lblTopping5  = new JLabel("Topping 5:");
        JLabel lblTopping6  = new JLabel("Topping 6:");
        JLabel lblNumPizza = new JLabel("Number of Pizzas: ");
        JLabel lblTotalCost = new JLabel("Total cost:");

        pnlLeft = new JPanel(layoutLeft);
        pnlLeft.setPreferredSize(dim);

        pnlLeft.add(blank);
        pnlLeft.add(blank1);
        pnlLeft.add(lblTopping1);
        pnlLeft.add(lblTopping2);
        pnlLeft.add(lblTopping3);
        pnlLeft.add(lblTopping4);
        pnlLeft.add(lblTopping5);
        pnlLeft.add(lblTopping6);

        pnlLeft.add(lblNumPizza);
        pnlLeft.add(lblTotalCost);


        add(pnlLeft, BorderLayout.WEST);
    }

        //skapar jcomboboxen samt skriver ut värden med hjälp av add.()
        private void createVariablesOnRightPanel()
    {
        cmbPizzas = new JComboBox(controller.getPizzaItems());
        cmbPizzas.addActionListener(controller);
        GridLayout layoutRight = new GridLayout(10, 1, 2, 2);
        pnlRight = new JPanel(layoutRight);
        Dimension dim =new Dimension(6*width / 10, height);
        pnlRight.setPreferredSize(dim);

        // Dimension dim = new Dimension(90, 50);
        txtNumPizza = new JLabel("0");
        txtNumPizza.setPreferredSize(dim);

        txtTotalCost = new JLabel("0");
        txtTotalCost.setPreferredSize(dim);

        lblText = new JLabel("");
        lblToppings = new JLabel[6];

        lblCost = new JLabel("70 SEK");
        lblCost.setPreferredSize(dim);

        pnlRight.add(cmbPizzas);
        pnlRight.add(lblText);

        for (int i = 0; i < lblToppings.length; i++)
        {
            lblToppings[i] = new JLabel();
            pnlRight.add(lblToppings[i]);
        }

        pnlRight.add(txtNumPizza);
        pnlRight.add(txtTotalCost);

        add(pnlRight, BorderLayout.CENTER);
    }

    public void updateSelectedPizza(String[] toppings)
    {

        // Rensar alla gamla toppings i arrayen
        for(int i = 0; i < maxToppings; i++)
        {
            lblToppings[i].setText("");
        }

        // Lägger till de nya toppings i arrayen
        for(int i = 0; i < toppings.length; i++)
        {
            lblToppings[i].setText(toppings[i]);
        }

    }

    public void setTxtNumPizza(String text)
    {
        txtNumPizza.setText(text);
    }

    public Object getTypeOfPizza()
    {
        return cmbPizzas.getSelectedItem();
    }

    public void setTxtTotalCost(String text)
    {
        txtTotalCost.setText(text);
    }
}




