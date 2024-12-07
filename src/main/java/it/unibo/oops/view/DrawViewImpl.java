package it.unibo.oops.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 */
public final class DrawViewImpl implements DrawView {
    private static final String FRAME_NAME = "OOP Survivors";
    private final JFrame frame = new JFrame(FRAME_NAME);

    /**
     * 
     */
    public DrawViewImpl() {
        final JPanel panel = new JPanel();
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.getContentPane().add(panel);
        this.frame.pack();
        this.frame.setLocationByPlatform(true);
        this.start();
    }

    @Override
    public void start() {
        this.frame.setVisible(true);
    }
}
