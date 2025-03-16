package one;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class textEditor implements ActionListener {

    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu fileMenus;
    private JMenuItem newItem, openItem, saveItem, closeItem;
    private JTextArea textArea;
    private JScrollPane scrollPane;

    public textEditor() {
        frame = new JFrame("Mt Text Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();

        fileMenus = new JMenu("File");

        newItem = new JMenuItem("New");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        closeItem = new JMenuItem("Close");

        newItem.addActionListener(this);
        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        closeItem.addActionListener(this);

        fileMenus.add(newItem);
        fileMenus.add(openItem);
        fileMenus.add(saveItem);
        fileMenus.addSeparator();
        fileMenus.add(closeItem);

        menuBar.add(fileMenus);
        frame.setJMenuBar(menuBar);

        scrollPane = new JScrollPane(textArea);
        textArea = new JTextArea(20, 50);
        scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(newItem)) {
            textArea.setText("");
        } else if (e.getSource().equals(openItem)) {
            openFile();
        } else if (e.getSource().equals(saveItem)) {
            saveFile();
        } else if (e.getSource().equals(closeItem)) {
            System.exit(0);
        }
    }

    public void openFile() {
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(frame);
        File path = fc.getSelectedFile();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line + "\n");
            }

            textArea.setText(content.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveFile() {
        JFileChooser fc = new JFileChooser();
        fc.showSaveDialog(frame);
        File path = fc.getSelectedFile();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            String text = textArea.getText();
            writer.write(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new textEditor();
    }
}
