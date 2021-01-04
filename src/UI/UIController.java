package UI;

import Domain.DomainControl.GameController;
import Domain.DomainControl.RunningMode;

import java.util.HashMap;

public class UIController implements UIListener {

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

    @Override
    public void onHomeScreen() {
        new HomeScreen();
    }

    @Override
    public void onConfigureScreen() {
        new ConfigureScreen();
    }

    @Override
    public void onStart(HashMap<String, String> configurationInfo) {
        initGame(configurationInfo);
        System.out.println(isGameRunning);
    }

    @Override
    public void onGameStart() {

    }

    @Override
    public void onGameOver() {

    }

    @Override
    public void onPause() {
        new PauseWindow(gameController);
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onCredits() {

    }

    @Override
    public void onOptions() {
        new OptionsWindow();
    }

    @Override
    public void onLoadScreen() {
        new LoadWindow();
    }

    @Override
    public void onSave() {
        new SaveWindow();
    }

    @Override
    public boolean isGameRunning() {
        return isGameRunning;
    }
}