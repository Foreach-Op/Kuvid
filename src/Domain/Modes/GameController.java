package Domain.Modes;

import java.awt.event.KeyEvent;
import java.util.HashMap;

public class GameController {

    BuildMode buildMode;
    RunningMode runningMode;

    public GameController(RunningMode runningMode){
        this.runningMode=runningMode;
        buildMode=new BuildMode();
    }

    public void startGame(HashMap<String, String> configurationInfo){
        buildMode.startNewGame(configurationInfo);
        runningMode.startGame();
    }

    public void LoadGame(String FileName){
        buildMode.loadTheGame(FileName);
        runningMode.startGame();
    }

    public void KeyAction(KeyEvent keyEvent){
        ///
    }







}
