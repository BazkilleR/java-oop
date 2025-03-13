package two;

import java.awt.*;
import javax.swing.*;

public class MyFrame {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Time");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        MyClock clock = new MyClock();
        Thread t = new Thread(clock);
        t.start();
        
        JPanel panel = new JPanel();
        panel.add(clock, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.NORTH);

        frame.setSize(300, 150);
        frame.setVisible(true);
    }
}
