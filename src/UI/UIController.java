package UI;

import Domain.DomainControl.GameController;
import Domain.DomainControl.RunningMode;

import java.util.HashMap;

public class UIController {

    private static UIController instance;

    private GameController gameController;

    public boolean isGameRunning = false;

    public static UIController GetInstance() {
        if (instance == null) {
            instance = new UIController();
        }
        return instance;
    }

    public UIController() {
        instance = this;
    }

    public void openHomeScreen() {
        new HomeScreen();
    }

    public void openConfigureScreen() {
        new ConfigureScreen();
    }

    public void openLoadWindow() {
        new LoadWindow();
    }

    public void openOptionsWindow() {
        new OptionsWindow();
    }

    public void openCreditsWindow() {

    }

    public void openPauseWindow() {
        new PauseWindow(gameController);
    }

    public void openSaveWindow() {
        new SaveWindow();
    }

    public void initGame(HashMap<String, String> configurationInfo) {
        GameScreen gameScreen = new GameScreen();
        RunningMode runningMode = new RunningMode(gameScreen);
        gameScreen.initialize(runningMode);
        gameController = GameController.getInstance();
        gameController.initialize(runningMode);
        gameController.setAudioListener(AudioController.GetInstance());
        gameController.StartGame(configurationInfo);
        gameScreen.InitializeGameScreen(gameController);

        isGameRunning = true;
    }
}