import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

/**
 * AddPage class provides an interface to add new items to the marketplace.
 */
public class AddPage implements ActionListener {

    private JFrame frame;
    private JPanel inputPanel, buttonPanel;
    private JLabel idLabel, nameLabel, priceLabel;
    private JTextField idField, nameField, priceField;
    private JDialog confirmationDialog;
    private JButton insertButton, closeButton;

    /**
     * Constructor initializes the UI components for adding items.
     */
    public AddPage() {
        frame = new JFrame("Add Page");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Input Panel
        inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        
        idLabel = new JLabel("ID:");
        nameLabel = new JLabel("Name:");
        priceLabel = new JLabel("Price:");

        idField = new JTextField();
        nameField = new JTextField();
        priceField = new JTextField();

        inputPanel.add(idLabel);
        inputPanel.add(idField);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(priceLabel);
        inputPanel.add(priceField);

        frame.add(inputPanel, BorderLayout.CENTER);

        // Button Panel
        buttonPanel = new JPanel();
        insertButton = new JButton("Insert Item");
        insertButton.addActionListener(this);
        buttonPanel.add(insertButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Inserts new item data into the database.
     */
    public void insertData() {
        String id = idField.getText().trim();
        String name = nameField.getText().trim();
        String price = priceField.getText().trim();

        try {
            int itemId = Integer.parseInt(id);
            double itemPrice = Double.parseDouble(price);
            Item newItem = new Item(itemId, name, itemPrice);

            // Load existing list from file
            ArrayList<Item> items = loadItems();
            items.add(newItem);

            // Save updated list back to file
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("jisoo_shop.dat"))) {
                oos.writeObject(items);
            }

            showConfirmationDialog();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid input format! Please enter valid ID and Price.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads the existing item list from the file.
     * @return A list of existing items or an empty list if the file does not exist.
     */
    private ArrayList<Item> loadItems() {
        File file = new File("jisoo_shop.dat");
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (ArrayList<Item>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Displays a success confirmation dialog when an item is added.
     */
    private void showConfirmationDialog() {
        confirmationDialog = new JDialog(frame, "Success", true);
        confirmationDialog.setLayout(new BorderLayout());
        confirmationDialog.setSize(250, 120);
        confirmationDialog.setLocationRelativeTo(frame);

        JLabel message = new JLabel("Done it", SwingConstants.CENTER);
        confirmationDialog.add(message, BorderLayout.NORTH);

        closeButton = new JButton("Close");
        closeButton.addActionListener(this);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(closeButton);
        confirmationDialog.add(buttonPanel, BorderLayout.SOUTH);

        confirmationDialog.setVisible(true);
    }

    /**
     * Handles button actions for inserting an item and closing the dialog.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(insertButton)) {
            insertData();
        } else if (e.getSource().equals(closeButton)) {
            confirmationDialog.dispose();
            frame.dispose();
            new DataPage();
        }
    }

    /**
     * Main method to launch the AddPage.
     */
    public static void main(String[] args) {
        new AddPage();
    }
}
