
import javax.swing.*;
import java.awt.*;

public class CalculatorTwoGUI {

    public JFrame fr;
    public JTextField tf;
    public JPanel p;
    public JButton[] buttons;
    public String[] strBTN;

    public CalculatorTwoGUI() {
        this.strBTN = new String[]{
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "x",
            "0", "c", "=", "/"
        };

        fr = new JFrame("My Calculator");
        p = new JPanel();
        tf = new JTextField();

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(500, 300);
        fr.setLayout(new BorderLayout());

        p.setLayout(new GridLayout(4, 4));
        buttons = new JButton[strBTN.length];

        for (int i = 0; i < strBTN.length; i++) {
            buttons[i] = new JButton(strBTN[i]);
            p.add(buttons[i]);
        }

        fr.add(tf, BorderLayout.NORTH);
        fr.add(p);

        fr.setVisible(true);
    }
}
