
import javax.swing.*;
import java.awt.*;

public class CalculatorOneGUI {

    public JFrame fr;
    public JPanel p1;
    public JButton b1, b2, b3, b4;
    public JTextField tf1, tf2, tf3;

    public CalculatorOneGUI() {
        fr = new JFrame();
        p1 = new JPanel();
        b1 = new JButton("plus");
        b2 = new JButton("minus");
        b3 = new JButton("multiply");
        b4 = new JButton("divide");
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setTitle("Calculator");
        fr.setSize(500, 200);
        fr.setLayout(new GridLayout(4, 1));

        p1.setLayout(new FlowLayout());
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);

        fr.add(tf1);
        fr.add(tf2);
        fr.add(p1);
        fr.add(tf3);

        fr.setVisible(true);
    }
}
