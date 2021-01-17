package UI;

import UI.Audio.AudioController;

public class Main {
    public static void main(String[] args) {
        UIController uiController = UIController.GetInstance();
        uiController.openHomeScreen();
        //uiController.openOptions();

        AudioController.GetInstance().onStart();
    }
}
