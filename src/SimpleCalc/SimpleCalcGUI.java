package SimpleCalc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalcGUI extends JFrame{
    private JPanel panel1;
    private JTextField tfNumber1;
    private JComboBox cbOperations;
    private JButton btnCompute;
    private JTextField tfNumber2;
    private JTextField lblResult;
    private boolean validityChecker1,validityChecker2;

    public SimpleCalcGUI(){
        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compute();
            }
        });
    }

    public static void main(String[] args) {
        SimpleCalcGUI calc = new SimpleCalcGUI();
        calc.setContentPane(calc.panel1);
        calc.setTitle("Simple Calculator");
        calc.setSize(550,200);
        calc.setDefaultCloseOperation(EXIT_ON_CLOSE);
        calc.setVisible(true);
    }

    public int getNum1(){
        int n1 = 0;
        try {
            validityChecker1 = true;
            n1 = Integer.parseInt(tfNumber1.getText());
        } catch (NumberFormatException e){
            validityChecker1 = false;
            JOptionPane.showMessageDialog(panel1,"Please enter the first number");
        }
        return n1;
    }

    public int getNum2(){
        int n2 = 0;
        try {
            validityChecker2 = true;
            n2 = Integer.parseInt(tfNumber2.getText());
        } catch(NumberFormatException e){
            validityChecker2 = false;
            JOptionPane.showMessageDialog(panel1,"Please enter the second number");
        }
        return n2;
    }

    public void compute(){
        int num1 = getNum1(), num2 = getNum2();
        int opInd = cbOperations.getSelectedIndex();
        int ans = 0;
        switch (opInd){
            case 0:
                ans = num1  + num2;
                break;
            case 1:
                ans = num1 - num2;
                break;
            case 2:
                ans = num1 * num2;
                break;
            case 3:
                try {
                    ans = num1 / num2;
                } catch (ArithmeticException e){
                    JOptionPane.showMessageDialog(panel1,"Cannot divide number by zero");
                    validityChecker2 = false;
                }
                break;
        }
        if (validityChecker1 && validityChecker2) {
            lblResult.setText(Integer.toString(ans));
        }
    }
}
