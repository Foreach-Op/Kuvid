package UI;

import Domain.DomainControl.GameController;
import Domain.DomainControl.RunningMode;
import UI.Audio.AudioController;

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

    GameScreen gameScreen;

    public void initGame(){
        gameScreen = new GameScreen();
        RunningMode runningMode = new RunningMode(gameScreen);
        gameScreen.initialize(runningMode);
        gameController = GameController.getInstance();
        gameController.initialize(runningMode);
        gameController.setAudioListener(AudioController.GetInstance());
    }

    public void newGame(HashMap<String, String> configurationInfo) {
        gameController.StartGame(configurationInfo);
        gameScreen.InitializeGameScreen(gameController);

        isGameRunning = true;
    }

    public void loadGame(){
        gameScreen.InitializeGameScreen(gameController);

        isGameRunning = true;
    }

    public void setConfigurationInfo(HashMap<String, String> configurationInfo){

    }

    public void initializeGame(){

    }

    public void openHomeScreen() {
        new HomeScreen();
    }

    public void openConfigureScreen() {
        new ConfigureScreen();
    }

    public void openSaveWindow() {
        new SaveWindow();
    }

    public void openLoadWindow() {
        new LoadWindow();
    }

    public void startGame(HashMap<String, String> configurationInfo) {
        initGame();
        newGame(configurationInfo);
    }

    public void endGame() {

    }

    public void pause() {
        new PauseWindow(gameController);
    }

    public void resume() {

    }

    public void openCredits() {

    }

    public void openOptions() {
        new OptionsWindow();
    }

    public boolean isGameRunning() {
        return isGameRunning;
    }
}