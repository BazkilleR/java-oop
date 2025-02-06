
import javax.swing.*;

public class MDIFromGUI {

    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu fileMenu, editMenu, viewMenu, newMenu;
    private JMenuItem openMenu, saveItem, exitItem, windowSubMenu, messageSubMenu;
    private JDesktopPane desktopPane;
    private JInternalFrame frame1, frame2, frame3;

    public MDIFromGUI() {
        // Setup Frame
        frame = new JFrame("SubMenuItem Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);

        // Setup Menu Bar
        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        // Create "File" Menu
        fileMenu = new JMenu("File");
        newMenu = new JMenu("New");

        // Add submenus under "New"
        windowSubMenu = new JMenuItem("Window");
        messageSubMenu = new JMenuItem("Message");
        newMenu.add(windowSubMenu);
        newMenu.addSeparator();
        newMenu.add(messageSubMenu);

        // Add menus under "File"
        fileMenu.add(newMenu);
        fileMenu.addSeparator();

        openMenu = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        fileMenu.add(openMenu);
        fileMenu.addSeparator();
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // Setup "Edit" and "View" Menus
        editMenu = new JMenu("Edit");
        viewMenu = new JMenu("View");

        // Add Menus to the Menu Bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);

        // Setup Desktop Pane and Internal Frames
        desktopPane = new JDesktopPane();
        frame.add(desktopPane);

        frame1 = new JInternalFrame("Application 01", true, true, true, true);
        frame2 = new JInternalFrame("Application 02", true, true, true, true);
        frame3 = new JInternalFrame("Application 01", true, true, true, true);

        // Setup internal frames
        frame1.setSize(300, 300);
        frame1.setLocation(0, 0);
        frame1.setVisible(true);

        frame2.setSize(300, 300);
        frame2.setLocation(300, 300);
        frame2.setVisible(true);

        frame3.setSize(300, 300);
        frame3.setLocation(600, 600);
        frame3.setVisible(true);

        // Add internal frames to the desktop pane
        desktopPane.add(frame1);
        desktopPane.add(frame2);
        desktopPane.add(frame3);

        // Display Frame
        frame.setVisible(true);
    }
}
