
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorSample implements ActionListener {

    // GUI Components
    private JFrame fr;
    private JTextField tf;
    private JPanel p;
    private JButton[] buttons;
    private String[] strBTN;

    // Calculation variables
    private int num1, num2;
    private String operator;

    public CalculatorSample() {
        this.strBTN = new String[]{
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "x",
            "0", "c", "=", "/"
        };

        setupFrame();
        setupButtons();
        fr.setVisible(true);
    }

    private void setupFrame() {
        fr = new JFrame("My Calculator");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(500, 300);
        fr.setLayout(new BorderLayout());

        tf = new JTextField();
        tf.setPreferredSize(new Dimension(0, 50));

        fr.add(tf, BorderLayout.NORTH);
    }

    private void setupButtons() {
        p = new JPanel();
        p.setLayout(new GridLayout(4, 4));
        buttons = new JButton[strBTN.length];

        for (int i = 0; i < strBTN.length; i++) {
            buttons[i] = new JButton(strBTN[i]);
            buttons[i].addActionListener(this);
            p.add(buttons[i]);
        }

        fr.add(p, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "c":
                clear();
                break;
            case "+":
            case "-":
            case "x":
            case "/":
                handleOperator(command);
                break;
            case "=":
                calculateResult();
                break;
            default:
                tf.setText(tf.getText() + command);
        }
    }

    private void clear() {
        tf.setText("");
        num1 = 0;
        num2 = 0;
        operator = null;
    }

    private void handleOperator(String operator) {
        num1 = Integer.parseInt(tf.getText());
        tf.setText("");
        this.operator = operator;
    }

    private void calculateResult() {
        if (operator == null) {
            return;
        }

        num2 = Integer.parseInt(tf.getText());
        int result = 0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "x":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    tf.setText("Error: Div by 0");
                    return;
                }
                result = num1 / num2;
                break;
        }

        tf.setText(String.valueOf(result));
        num1 = result;
        num2 = 0;
        operator = null;
    }

    public static void main(String[] args) {
        new CalculatorSample();
    }
}
