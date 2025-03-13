package two;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class MyClock extends JLabel implements Runnable {

    @Override
    public void run() {
        while (true) {
            Calendar calendar = Calendar.getInstance();
            int sec = calendar.get(Calendar.SECOND);
            int min = calendar.get(Calendar.MINUTE);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);

            this.setFont(new Font("Arial", Font.BOLD, 24));
            this.setText(String.format("%02d:%02d:%02d", hour, min, sec));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
