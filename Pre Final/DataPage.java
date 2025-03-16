
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

/**
 * DataPage class represents the main marketplace interface. It displays
 * available products and allows users to add, edit, or logout.
 */
public class DataPage implements ActionListener {

    private JFrame frame;
    private JPanel p1, p2, optionPanel;
    private JLabel welcomeText;
    private JButton addBtn, editBtn, logoutBtn;
    private JScrollPane tableScroll;
    private JTable productTable;
    private DefaultTableModel model;
    private String[] columns = {"ID", "Name", "Price", "Created_On"};

    /**
     * Constructor initializes the UI components and loads product data.
     */
    public DataPage() {
        frame = new JFrame("Data Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Header Panel
        p1 = new JPanel(new BorderLayout());
        p2 = new JPanel();
        welcomeText = new JLabel("Welcome to Jisoo Marketplace");
        p2.add(welcomeText);
        p1.add(p2, BorderLayout.NORTH);

        // Buttons Panel
        optionPanel = new JPanel();
        addBtn = new JButton("Add item");
        editBtn = new JButton("Edit item");
        logoutBtn = new JButton("Logout");

        // Attach action listeners to buttons
        addBtn.addActionListener(this);
        editBtn.addActionListener(this);
        logoutBtn.addActionListener(this);

        optionPanel.add(addBtn);
        optionPanel.add(editBtn);
        optionPanel.add(logoutBtn);
        p1.add(optionPanel, BorderLayout.SOUTH);

        // Table Setup
        model = new DefaultTableModel(columns, 0);
        productTable = new JTable(model);
        tableScroll = new JScrollPane(productTable);

        // Add components to frame
        frame.add(p1, BorderLayout.NORTH);
        frame.add(tableScroll, BorderLayout.CENTER);

        // Set frame properties
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Load data into table
        loadData();
    }

    /**
     * Loads product data from a file and displays it in the table.
     */
    public void loadData() {
        File data = new File("jisoo_shop.dat");
        if (!data.exists()) {
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(data))) {
            ArrayList<Item> items = (ArrayList<Item>) ois.readObject();
            model.setRowCount(0); // Clear table before loading

            for (Item item : items) {
                model.addRow(new Object[]{item.getId(), item.getName(), item.getPrice(), item.getFormattedTime()});
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles button clicks for adding, editing, and logging out.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(addBtn)) {
            new AddPage(); // Open AddPage
            frame.dispose();
        } else if (e.getSource().equals(editBtn)) {
            new EditPage(); // Open EditPage
            frame.dispose();
        } else if (e.getSource().equals(logoutBtn)) {
            frame.dispose(); // Close current window
            new LoginPage(); // Return to login page
        }
    }

    /**
     * Main method to launch the DataPage.
     */
    public static void main(String[] args) {
        new DataPage();
    }
}
