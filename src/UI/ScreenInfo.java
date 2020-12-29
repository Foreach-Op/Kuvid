package UI;

import java.awt.*;

public interface ScreenInfo {
    int WINDOW_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    int WINDOW_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
    //int WINDOW_WIDTH = 1280;
    //int WINDOW_HEIGHT = 720;

    int SCROLL_INCREMENT_AMOUNT = WINDOW_HEIGHT/100;

    Font titleFont = new Font("Text Me One", Font.PLAIN, WINDOW_HEIGHT/15);
    Font buttonFont = new Font("Text Me One", Font.PLAIN, WINDOW_HEIGHT/22);
    Font textFontMedium = new Font("Text Me One", Font.PLAIN, WINDOW_HEIGHT/25);
    Font textFontSmall = new Font("Text Me One", Font.PLAIN, WINDOW_HEIGHT/35);

    Color buttonBackgroundColor = Color.decode("#E1E1E1");
    Color buttonTextColor = Color.BLACK;
    Color borderColor = Color.GRAY;
}
