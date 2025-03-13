
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChatDemo implements ActionListener {

    private JFrame frame;
    private JPanel buttonPanel;
    private JTextArea textArea;
    private JTextField textField;
    private JButton submitButton, resetButton;
    private static final String FILE_NAME = "ChatDemo.dat";

    public ChatDemo() {
        // Setting up JFrame
        frame = new JFrame("Chat Demo");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Text area (Chat Display)
        textArea = new JTextArea(15, 30);
        textArea.setEditable(false);
        textArea.setForeground(Color.GRAY);
        frame.add(textArea, BorderLayout.NORTH);

        // Load chat history from file
        loadChatHistory();

        // Text field (User Input)
        textField = new JTextField();
        frame.add(textField, BorderLayout.CENTER);

        // Panel for buttons
        buttonPanel = new JPanel();

        // Submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        buttonPanel.add(submitButton);

        // Reset button
        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        buttonPanel.add(resetButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Save chat history when closing window
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveChatHistory();
                System.exit(0);
            }
        });

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        String text = textField.getText().trim();

        if (command.equals("Submit")) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            String timestamp = dtf.format(LocalDateTime.now());
            textArea.append(timestamp + " : " + text + "\n");
            textField.setText("");
        } else if (command.equals("Reset")) {
            textArea.setText("");
        }
    }

    private void loadChatHistory() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (FileReader fileReader = new FileReader(file)) {
                int ch;
                StringBuilder content = new StringBuilder();
                while ((ch = fileReader.read()) != -1) {
                    content.append((char) ch);
                }
                textArea.setText(content.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveChatHistory() {
        try (FileWriter fileWriter = new FileWriter(FILE_NAME)) {
            fileWriter.write(textArea.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ChatDemo();
    }
}
