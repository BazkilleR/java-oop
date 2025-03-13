/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package four;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyTimer extends JLabel implements Runnable {

    private int hours = 0, minutes = 0, seconds = 0;
    private boolean running = true;
    private boolean paused = false; // Pause state

    public MyTimer() {
        setFont(new Font("Arial", Font.BOLD, 30));
        setHorizontalAlignment(SwingConstants.CENTER);
        updateTimeLabel();

        // Add Mouse Listener for Pause/Resume
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                togglePause();
            }
        });
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(1000); // Wait for 1 second

                if (!paused) { // Only update time if not paused
                    incrementTime();
                    updateTimeLabel();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Increase time by 1 second
    private void incrementTime() {
        seconds++;
        if (seconds == 60) {
            seconds = 0;
            minutes++;
        }
        if (minutes == 60) {
            minutes = 0;
            hours++;
        }
    }

    // Format and update label text
    private void updateTimeLabel() {
        String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        setText(time);
    }

    // Toggle Pause/Resume
    private void togglePause() {
        paused = !paused;
    }

    // Stop the timer
    public void stopTimer() {
        running = false;
    }
}
