package it.unibo.mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();
    private final Controller contr = new SimpleController();

    public SimpleGUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Main panel
        final JPanel panel = new JPanel(new BorderLayout());
        final JTextField text = new JTextField();
        final JTextArea history = new JTextArea();
        history.setEditable(false);
        panel.add(text, BorderLayout.NORTH);
        panel.add(history, BorderLayout.CENTER);

        // Second panel
        final JPanel bottomPanel = new JPanel(new BorderLayout());
        final JButton print = new JButton("Print");
        final JButton showHistory = new JButton("Show history");
        bottomPanel.add(print, BorderLayout.CENTER);
        bottomPanel.add(showHistory, BorderLayout.LINE_END);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        frame.setContentPane(panel);

        /*
         * Handlers
         */
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contr.setNextString(text.getText());
                contr.printString();
            }
        });

        showHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final List<String> prints = contr.getPrintHistory();
                history.setText("");
                for (final var str : prints) {
                    history.append(str + "\n");
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
