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
        return Integer.parseInt(tfNumber1.getText());
    }

    public int getNum2(){
        return Integer.parseInt(tfNumber2.getText());
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
                ans = num1/num2;
                break;
        }

        lblResult.setText(Integer.toString(ans));
    }
}
