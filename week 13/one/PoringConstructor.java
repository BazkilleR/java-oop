package one;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PoringConstructor implements Runnable {

    private JFrame frame;
    private JButton addButton;

    public PoringConstructor() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        frame = new JFrame("Poring Spawner");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        addButton = new JButton("Add Poring");
        addButton.addActionListener(new AddPoringListener());

        JPanel panel = new JPanel();
        panel.add(addButton);
        frame.add(panel, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    // Named inner class for handling button click events
    private class AddPoringListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Poring.increaseCount();
        }
    }

    public static void main(String[] args) {
        new PoringConstructor();
    }
}
