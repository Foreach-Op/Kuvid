package Domain.Modes;

import java.util.HashMap;

public class GameController {

    BuildingMode buildingMode;
    RunningMode runningMode;

    public boolean isBlendModeActive = false;

    public GameController(RunningMode runningMode) {
        this.runningMode = runningMode;
        buildingMode = new BuildingMode();
    }

    public void startGame(HashMap<String, String> configurationInfo) {
        buildingMode.startNewGame(configurationInfo);
        runningMode.startGame();
    }

    public void LoadGame(String FileName) {
        buildingMode.loadTheGame(FileName);
        runningMode.startGame();
    }

    public void Move(String direction) {
        System.out.println("Moving through " + direction);
    }

    public void Rotate(String direction) {
        System.out.println("Rotating through " + direction);
    }

    public void PickAtom() {
        System.out.println("Atom changed randomly.");
    }

    public void Shoot() {
        System.out.println("SHOOT");
    }

    public void Blend() {
        if (isBlendModeActive) {
            isBlendModeActive = false;
        } else {
            isBlendModeActive = true;
        }
        System.out.println("Blend Mode: " + isBlendModeActive);
    }

    public void Pause() {
        System.out.println("pause");
    }

    public void Resume() {
        System.out.println("resume");
    }

    public void ChooseAtomForBlender(int type){
        if(isBlendModeActive) {
            System.out.println("Atom " + type);
        }
    }
}
