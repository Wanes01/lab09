package it.unibo.mvc;

import java.io.File;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final static int PROPORTION = 5;
    private final JFrame frame = new JFrame();
    private final Controller contr = new Controller();

    public SimpleGUIWithFileChooser() {
        // Main panel components
        final JPanel panel = new JPanel(new BorderLayout());
        final JTextArea textArea = new JTextArea();
        final JButton save = new JButton("save");

        // Second panel
        final JPanel topPanel = new JPanel(new BorderLayout());
        final JTextField selectedFile = new JTextField();
        final JButton browse = new JButton("Browse...");
        selectedFile.setEditable(false);

        topPanel.add(selectedFile, BorderLayout.CENTER);
        topPanel.add(browse, BorderLayout.LINE_END);

        panel.add(topPanel, BorderLayout.NORTH);
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

        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JFileChooser fileChooser = new JFileChooser();
                final int result = fileChooser.showSaveDialog(frame);
                switch (result) {
                    case JFileChooser.APPROVE_OPTION:
                        final File fileToSet = fileChooser.getSelectedFile();
                        contr.setFile(fileToSet);
                        selectedFile.setText(fileToSet.getPath());
                        break;
                    case JFileChooser.CANCEL_OPTION:
                        break;
                    default:
                        JOptionPane.showMessageDialog(
                                frame,
                                "An error occured during the file selection.",
                                "ERROR",
                                JOptionPane.ERROR_MESSAGE);
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
        SimpleGUIWithFileChooser sg = new SimpleGUIWithFileChooser();
        sg.show();
    }

}
