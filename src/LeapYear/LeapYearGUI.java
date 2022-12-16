package LeapYear;

import javax.swing.*;

public class LeapYearGUI extends JFrame{
    private JPanel panel1;
    private JTextField tfYear;
    private JButton btnCheckYear;

    public static void main(String[] args) {
        LeapYearGUI leap = new LeapYearGUI();
        leap.setContentPane(leap.panel1);
        leap.setTitle("Leap Year Checker");
        leap.setSize(500,300);
        leap.setDefaultCloseOperation(EXIT_ON_CLOSE);
        leap.setVisible(true);
    }
}
