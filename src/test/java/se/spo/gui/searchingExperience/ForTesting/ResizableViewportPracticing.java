package se.spo.gui.searchingExperience.ForTesting;

import java.awt.Toolkit;
import java.awt.Dimension;

public class ResizableViewportPracticing {

    public static void main(String[] args)
    {
        // getScreenSize() returns the size
        // of the screen in pixels
        Dimension size
                = Toolkit.getDefaultToolkit().getScreenSize();

        // width will store the width of the screen
        int width = (int)size.getWidth();

        // height will store the height of the screen
        int height = (int)size.getHeight();

        System.out.println("Current Screen resolution : "
                + "width : " + width
                + " height : " + height);
    }
}
