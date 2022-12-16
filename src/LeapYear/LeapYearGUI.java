package LeapYear;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LeapYearGUI extends JFrame{
    private JPanel panel1;
    private JTextField tfYear;
    private JButton btnCheckYear;

    public LeapYearGUI(){
        btnCheckYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leapCompute();
            }
        });

        tfYear.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    leapCompute();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        LeapYearGUI leap = new LeapYearGUI();
        leap.setContentPane(leap.panel1);
        leap.setTitle("Leap Year Checker");
        leap.setSize(500,300);
        leap.setDefaultCloseOperation(EXIT_ON_CLOSE);
        leap.setVisible(true);
    }


    public int yearEntered () {
        int year;
        year = Integer.parseInt(tfYear.getText());
        return year;
    }



    public void leapCompute(){
        int year = yearEntered();
        try {
            if(year > 1582) {
                if (year % 4 == 0) {
                    if (year % 100 == 0) {
                        if (year % 400 == 0) {
                            JOptionPane.showMessageDialog(panel1, "Leap year");
                        } else {
                            JOptionPane.showMessageDialog(panel1, "Not a leap year");
                        }
                    } else {
                        JOptionPane.showMessageDialog(panel1, "Leap year");
                    }
                } else {
                    JOptionPane.showMessageDialog(panel1, "Not a leap year");
                }
            } else {
                throw new IllegalArgumentException();
            }
        } catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(panel1,"Year must be greater than 1582");
        }
    }


}
