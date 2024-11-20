package it.unibo.mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final static int PROPORTION = 5;
    private final JFrame frame = new JFrame();
    private final Controller contr = new Controller();

    public SimpleGUI() {
        final JPanel panel = new JPanel(new BorderLayout());
        final JTextArea textArea = new JTextArea();
        final JButton save = new JButton("save");
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(save, BorderLayout.SOUTH);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    contr.saveOnFile(textArea.getText());
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
    }

    public void show() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static final void main(String[] args) {
        final SimpleGUI sg = new SimpleGUI();
        sg.show();
    }
}
