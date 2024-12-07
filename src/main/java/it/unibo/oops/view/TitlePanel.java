package it.unibo.oops.view;

import java.awt.Dimension;
/**
 * 
 */
public class TitlePanel extends MyPanel {
    private static final double serialVersionUID = getSerialVersionUID();
    /**
     * @param screenWidth
     * @param screenHeight
     */
    public TitlePanel(final int screenWidth, final int screenHeight) {
        super.setPreferredSize(new Dimension(screenWidth, screenHeight));
    }
}
