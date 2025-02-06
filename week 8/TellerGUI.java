
import javax.swing.*;
import java.awt.*;

public class TellerGUI {

    public JFrame frame;
    public JPanel inputPanel, buttonPanel;
    public JLabel balanceLabel, amountLabel;
    public JButton depositButton, withdrawButton, exitButton;
    public JTextField balanceField, amountField;

    public TellerGUI() {
        frame = new JFrame("Teller GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new GridLayout(2, 1));

        inputPanel = new JPanel(new GridLayout(2, 2));
        balanceLabel = new JLabel("Balance:");
        amountLabel = new JLabel("Amount:");

        balanceField = new JTextField("6000");
        balanceField.setEditable(false);

        amountField = new JTextField();

        inputPanel.add(balanceLabel);
        inputPanel.add(balanceField);
        inputPanel.add(amountLabel);
        inputPanel.add(amountField);

        buttonPanel = new JPanel();
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        exitButton = new JButton("Exit");

        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(exitButton);

        frame.add(inputPanel);
        frame.add(buttonPanel);

        frame.setVisible(true);
    }
}
