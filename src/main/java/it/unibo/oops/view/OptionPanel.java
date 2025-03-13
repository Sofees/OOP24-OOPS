package it.unibo.oops.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

//import java.awt.event.ActionListener;
import it.unibo.oops.controller.gamestate.GameState;
//import it.unibo.oops.view.DrawView;

/**
*
*/
public class OptionPanel extends MyPanel {
    @SuppressWarnings("unused") // TEMPORARY
    private static final double serialVersionUID = getSerialVersionUID();
    //private final DrawView drawView;

    /**
     * @param screenWidth
     * @param screenHeight
     */
    public OptionPanel(final int screenWidth, final int screenHeight, final DrawView drawView) {
        super.setPreferredSize(new Dimension(screenWidth, screenHeight));
        super.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Settings", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        super.add(titleLabel, BorderLayout.NORTH);

        JPanel outerPanel = new JPanel(new BorderLayout());
        outerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 10, 10));


        JButton fullscreenButton = new JButton("Fullscreen");
        JButton screenSizeButton = new JButton("Screen Size");
        JButton volumeButton = new JButton("Volume");
        JButton sfxButton = new JButton("SFX");
        JButton returnButton = new JButton("Return");


        fullscreenButton.addActionListener(e -> toggleFullscreen());
        screenSizeButton.addActionListener(e -> changeScreenSize());
        returnButton.addActionListener(e -> drawView.changeGameState(GameState.TITLESTATE));

        buttonPanel.add(fullscreenButton);
        buttonPanel.add(screenSizeButton);
        buttonPanel.add(volumeButton);
        buttonPanel.add(sfxButton);
        buttonPanel.add(returnButton);

        //super.add(buttonPanel, BorderLayout.CENTER);
        outerPanel.add(buttonPanel, BorderLayout.CENTER);
        super.add(outerPanel, BorderLayout.WEST);
    }

    private void toggleFullscreen() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (frame != null) {
            boolean isFullscreen = frame.getExtendedState() == JFrame.MAXIMIZED_BOTH;
            if (isFullscreen) {
                frame.setExtendedState(JFrame.NORMAL);
            } else {
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        }
    }

    private void changeScreenSize() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (frame != null) {
            String widthInput = JOptionPane.showInputDialog(frame, "Enter width:", "Screen Size", JOptionPane.PLAIN_MESSAGE);
            String heightInput = JOptionPane.showInputDialog(frame, "Enter height:", "Screen Size", JOptionPane.PLAIN_MESSAGE);
            
            if (widthInput != null && heightInput != null) {
                try {
                    int width = Integer.parseInt(widthInput);
                    int height = Integer.parseInt(heightInput);
                    frame.setSize(width, height);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please enter numeric values.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    

}
