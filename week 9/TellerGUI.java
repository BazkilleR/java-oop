
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TellerGUI implements ActionListener {

    private JFrame frame;
    private JPanel inputPanel, buttonPanel;
    private JLabel balanceLabel, amountLabel;
    private JButton depositButton, withdrawButton, exitButton;
    private JTextField balanceField, amountField;
    private double balance;

    public TellerGUI() {
        this.balance = 6000;

        // Setting up the frame
        frame = new JFrame("Teller GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new GridLayout(2, 1));

        setupInputPanel();
        setupButtonPanel();

        frame.add(inputPanel);
        frame.add(buttonPanel);

        frame.setVisible(true);
    }

    private void setupInputPanel() {
        inputPanel = new JPanel(new GridLayout(2, 2));
        balanceLabel = new JLabel("Balance:");
        amountLabel = new JLabel("Amount:");

        balanceField = new JTextField(String.valueOf(balance));
        balanceField.setEditable(false);

        amountField = new JTextField();

        inputPanel.add(balanceLabel);
        inputPanel.add(balanceField);
        inputPanel.add(amountLabel);
        inputPanel.add(amountField);
    }

    private void setupButtonPanel() {
        buttonPanel = new JPanel();

        depositButton = new JButton("Deposit");
        depositButton.addActionListener(this);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(this);

        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);

        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(exitButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        double amount = parseAmount(amountField.getText());

        switch (command) {
            case "Withdraw":
                handleWithdraw(amount);
                break;
            case "Deposit":
                handleDeposit(amount);
                break;
            case "Exit":
                System.exit(0);
            default:
                break;
        }
    }

    private double parseAmount(String text) {
        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

    private void handleWithdraw(double amount) {
        if (balance < amount) {
            return;
        }
        balance -= amount;
        balanceField.setText(String.valueOf(balance));
    }

    private void handleDeposit(double amount) {
        balance += amount;
        balanceField.setText(String.valueOf(balance));
    }

    public static void main(String[] args) {
        new TellerGUI();
    }
}
