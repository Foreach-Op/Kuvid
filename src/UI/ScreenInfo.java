package UI;

import java.awt.*;

public interface ScreenInfo {
    int WINDOW_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    int WINDOW_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    int SCROLL_INCREMENT_AMOUNT = WINDOW_HEIGHT/100;

    Font titleFont = new Font("Text Me One", Font.PLAIN, 72);
    Font buttonFont = new Font("Text Me One", Font.PLAIN, 36);
    Font textFont = new Font("Text Me One", Font.PLAIN, 24);

    Color buttonBackgroundColor = Color.decode("#E1E1E1");
    Color buttonTextColor = Color.decode("#63ACB5");
    Color borderColor = Color.GRAY;
}
