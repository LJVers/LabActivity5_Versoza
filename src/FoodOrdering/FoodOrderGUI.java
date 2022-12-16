package FoodOrdering;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FoodOrderGUI extends JFrame {
    private JPanel panel1;
    private JCheckBox cPizza;
    private JRadioButton rbNone;
    private JButton btnOrder;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;

    private List<JRadioButton> rbDiscounts;
    private List<JCheckBox> cbFood;

    public FoodOrderGUI(){
        rbDiscounts = new ArrayList<>();
        rbDiscounts.add(rbNone);
        rbDiscounts.add(rb5);
        rbDiscounts.add(rb10);
        rbDiscounts.add(rb15);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbNone);
        bg.add(rb5);
        bg.add(rb10);
        bg.add(rb15);

        cbFood = new ArrayList<>();
        cbFood.add(cPizza);
        cbFood.add(cBurger);
        cbFood.add(cFries);
        cbFood.add(cSoftDrinks);
        cbFood.add(cTea);
        cbFood.add(cSundae);

        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcOrder();
            }
        });
    }
    public static void main(String[] args) {
        FoodOrderGUI foodOrder = new FoodOrderGUI();
        foodOrder.setContentPane(foodOrder.panel1);
        foodOrder.setSize(500,550);
        foodOrder.setTitle("Food Ordering System");
        foodOrder.setDefaultCloseOperation(EXIT_ON_CLOSE);
        foodOrder.setVisible(true);
    }

    public String discount(){
        String disc = null;
        for(JRadioButton rb: rbDiscounts){
            if(rb.isSelected()){
                disc = rb.getText();
            }
        }
        return disc;
    }

    public void calcOrder() {
        try {
            double sum = 0;
            boolean foodFound = false;
            for (JCheckBox cb : cbFood) {
                if (cb.isSelected()) {
                    foodFound = true;
                    switch (cb.getText()) {
                        case "Pizza":
                            sum += 100.00;
                            break;
                        case "Burger":
                            sum += 80.00;
                            break;
                        case "Fries":
                            sum += 65.00;
                            break;
                        case "Soft Drinks":
                            sum += 55.00;
                            break;
                        case "Tea":
                            sum += 50.00;
                            break;
                        case "Sundae":
                            sum += 40.00;
                            break;
                    }
                }
            }

            if (!foodFound) {
                throw new IllegalArgumentException();
            }

            double amt = 0;

            switch (discount()) {
                case "None":
                    amt = sum;
                    break;
                case "5% Off":
                    amt = sum * 0.95;
                    break;
                case "10% Off":
                    amt = sum * 0.90;
                    break;
                case "15% Off":
                    amt = sum * 0.85;
                    break;
            }

            JOptionPane.showMessageDialog(panel1, String.format("The total price is Php %.2f", amt));

        } catch (IllegalArgumentException e){
            JOptionPane.showMessageDialog(panel1, "You must select at least one food");
        } catch (NullPointerException e){
            JOptionPane.showMessageDialog(panel1,"Please select a discount promo");
        }
    }

}
