package one;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Poring {

    private static int count = 0;
    private JFrame frame;
    private Random random = new Random();

    public Poring() {
        frame = createFrame();
        frame.add(createPoringLabel());
        frame.add(createCountLabel());

        frame.pack();
        setRandomLocation(frame);
        frame.setVisible(true);

        startMoving();
    }

    private JFrame createFrame() {
        JFrame frame = new JFrame("Poring " + (count + 1));
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setResizable(false);

        frame.addMouseListener(new PoringClickListener(frame));

        return frame;
    }

    private JLabel createPoringLabel() {
        ImageIcon originalIcon = new ImageIcon("src/one/poring.png");
        ImageIcon resizedIcon = resizeIcon(originalIcon, 150);
        return new JLabel(resizedIcon);
    }

    private JLabel createCountLabel() {
        return new JLabel("Count: " + count);
    }

    private ImageIcon resizeIcon(ImageIcon icon, int newWidth) {
        int newHeight = (icon.getIconHeight() * newWidth) / icon.getIconWidth();
        Image resizedImg = icon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }

    private void setRandomLocation(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = random.nextInt(screenSize.width - frame.getWidth());
        int y = random.nextInt(screenSize.height - frame.getHeight());
        frame.setLocation(x, y);
    }

    public static void increaseCount() {
        count++;
        new Poring();
    }

    private void startMoving() {
        new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(50);
                    int dx = random.nextBoolean() ? 5 : -5;
                    int dy = random.nextBoolean() ? 5 : -5;
                    SwingUtilities.invokeLater(() -> {
                        frame.setLocation(frame.getX() + dx, frame.getY() + dy);
                    });
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    // Named inner class for handling mouse click events
    private static class PoringClickListener extends MouseAdapter {

        private JFrame frame;

        public PoringClickListener(JFrame frame) {
            this.frame = frame;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            frame.dispose();
        }
    }
}
