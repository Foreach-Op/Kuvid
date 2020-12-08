package Domain.Modes;

import java.awt.event.KeyEvent;
import java.util.HashMap;

public class GameController {

    BuildingMode buildingMode;
    RunningMode runningMode;

    public GameController(RunningMode runningMode){
        this.runningMode=runningMode;
        buildingMode =new BuildingMode();
    }

    public void startGame(HashMap<String, String> configurationInfo){
        buildingMode.startNewGame(configurationInfo);
        runningMode.startGame();
    }

    public void LoadGame(String FileName){
        buildingMode.loadTheGame(FileName);
        runningMode.startGame();
    }

    public void KeyAction(KeyEvent keyEvent){
        ///
    }







}
