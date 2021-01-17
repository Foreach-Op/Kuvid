package UI;

import UI.Audio.AudioController;

public class MainTest {
    public static void main(String[] args) {
        UIController uiController = UIController.GetInstance();
        uiController.openHomeScreen();

        AudioController.GetInstance().onStart();
    }
}
