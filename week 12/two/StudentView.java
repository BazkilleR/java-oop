package two;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentView implements ActionListener {
    private JFrame frame;
    private JPanel entryPanel, buttonPanel;
    private JLabel nameLabel, IDLabel, moneyLabel;
    private JTextField nameEntry, IDEntry, moneyEntry;
    private JButton depositButton, withdrawButton;

    private Student student;
    private static final String FILE_NAME = "StudentM.dat";

    public StudentView() {
        // Load student data from file
        student = Student.loadStudent(FILE_NAME);

        // Setup JFrame
        frame = new JFrame("Student Profile");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create Entry Panel (for ID, Name, and Money)
        entryPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        IDLabel = new JLabel("ID:");
        IDEntry = new JTextField(String.valueOf(student.getID()));
        entryPanel.add(IDLabel);
        entryPanel.add(IDEntry);

        nameLabel = new JLabel("Name:");
        nameEntry = new JTextField(student.getName());
        entryPanel.add(nameLabel);
        entryPanel.add(nameEntry);

        moneyLabel = new JLabel("Money:");
        moneyEntry = new JTextField(String.valueOf(student.getMoney()));
        moneyEntry.setEditable(false);
        entryPanel.add(moneyLabel);
        entryPanel.add(moneyEntry);

        frame.add(entryPanel, BorderLayout.CENTER);

        // Create Button Panel (Deposit & Withdraw Buttons)
        buttonPanel = new JPanel(new FlowLayout());
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");

        // Register ActionListener (this) for both buttons
        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);

        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Save data when closing window
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveStudentData();
                System.exit(0);
            }
        });

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Handles button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == depositButton) {
            student.deposit();
        } else if (e.getSource() == withdrawButton) {
            student.withdraw();
        }
        updateMoneyField();
    }

    // Update the money field display
    private void updateMoneyField() {
        moneyEntry.setText(String.valueOf(student.getMoney()));
    }

    // Save student data when closing the program
    private void saveStudentData() {
        student.setName(nameEntry.getText());
        student.setID(Integer.parseInt(IDEntry.getText()));
        Student.saveStudent(student, FILE_NAME);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentView::new);
    }
}
