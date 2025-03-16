import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

/**
 * EditPage class allows users to edit, delete, and navigate through items.
 */
public class EditPage implements ActionListener {

    private JFrame frame;
    private JPanel panel1, panel2, indexPanel;
    private JLabel idLabel, nameLabel, priceLabel;
    private JTextField idField, nameField, priceField;
    private JButton deleteBtn, updateBtn, closeBtn, increaseBtn, decreaseBtn, closeDialogBtn;
    private JDialog dialog;
    private int itemIndex = 0;
    private ArrayList<Item> items;

    /**
     * Constructor initializes the UI components for editing items.
     */
    public EditPage() {
        frame = new JFrame("Edit Page");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Input Panel
        panel1 = new JPanel(new GridLayout(3, 2, 10, 10));

        idLabel = new JLabel("ID:");
        nameLabel = new JLabel("Name:");
        priceLabel = new JLabel("Price:");

        idField = new JTextField();
        nameField = new JTextField();
        priceField = new JTextField();

        panel1.add(idLabel);
        panel1.add(idField);
        panel1.add(nameLabel);
        panel1.add(nameField);
        panel1.add(priceLabel);
        panel1.add(priceField);

        frame.add(panel1, BorderLayout.NORTH);

        // Navigation Panel
        indexPanel = new JPanel();
        decreaseBtn = new JButton("<<");
        increaseBtn = new JButton(">>");

        decreaseBtn.addActionListener(this);
        increaseBtn.addActionListener(this);

        indexPanel.add(decreaseBtn);
        indexPanel.add(increaseBtn);
        frame.add(indexPanel, BorderLayout.CENTER);

        // Button Panel
        panel2 = new JPanel();
        deleteBtn = new JButton("Delete Item");
        updateBtn = new JButton("Update Item");
        closeBtn = new JButton("Close Item");

        deleteBtn.addActionListener(this);
        updateBtn.addActionListener(this);
        closeBtn.addActionListener(this);

        panel2.add(deleteBtn);
        panel2.add(updateBtn);
        panel2.add(closeBtn);
        frame.add(panel2, BorderLayout.SOUTH);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        showItem();
    }

    /**
     * Loads items from the data file.
     */
    public void loadItems() {
        File file = new File("jisoo_shop.dat");
        if (!file.exists()) {
            items = new ArrayList<>();
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            items = (ArrayList<Item>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            items = new ArrayList<>();
        }
    }

    /**
     * Displays the current item in the input fields.
     */
    public void showItem() {
        loadItems();
        if (items.isEmpty()) {
            idField.setText("-");
            nameField.setText("-");
            priceField.setText("-");
        } else {
            Item currentItem = items.get(itemIndex);
            idField.setText(Integer.toString(currentItem.getId()));
            nameField.setText(currentItem.getName());
            priceField.setText(Double.toString(currentItem.getPrice()));
        }
    }

    /**
     * Saves the updated item list back to the file.
     */
    public void saveFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("jisoo_shop.dat"))) {
            oos.writeObject(items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes the current item from the list.
     */
    public void deleteItem() {
        items.remove(itemIndex);
        saveFile();
        showSuccessDialog();
    }

    /**
     * Displays a confirmation dialog after an action.
     */
    private void showSuccessDialog() {
        dialog = new JDialog(frame, "Success", true);
        dialog.setLayout(new FlowLayout());
        dialog.setSize(200, 100);
        dialog.setLocationRelativeTo(frame);

        JLabel message = new JLabel("Done it");
        closeDialogBtn = new JButton("Close");
        closeDialogBtn.addActionListener(e -> {
            dialog.dispose();
            frame.dispose();
            new DataPage();
        });

        dialog.add(message);
        dialog.add(closeDialogBtn);
        dialog.setVisible(true);
    }

    /**
     * Updates the current item with new data.
     */
    public void updateItem() {
        try {
            items.get(itemIndex).setId(Integer.parseInt(idField.getText()));
            items.get(itemIndex).setName(nameField.getText());
            items.get(itemIndex).setPrice(Double.parseDouble(priceField.getText()));
            saveFile();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid input! Please enter valid data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Handles button actions for deleting, updating, closing, and navigating items.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(deleteBtn)) {
            deleteItem();
        } else if (e.getSource().equals(closeBtn)) {
            frame.dispose();
            new DataPage();
        } else if (e.getSource().equals(updateBtn)) {
            updateItem();
        } else if (e.getSource().equals(increaseBtn)) {
            if (itemIndex < items.size() - 1) {
                itemIndex++;
                showItem();
            }
        } else if (e.getSource().equals(decreaseBtn)) {
            if (itemIndex > 0) {
                itemIndex--;
                showItem();
            }
        }
    }

    /**
     * Main method to launch the EditPage.
     */
    public static void main(String[] args) {
        new EditPage();
    }
}