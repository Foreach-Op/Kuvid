package Domain.Modes;

import java.util.HashMap;

public class GameController {

    BuildingMode buildingMode;
    RunningMode runningMode;

    private boolean isBlendModeActive = false;
    private boolean isFirstAtomSelected = false;
    private boolean isSecondAtomSelected = false;

    private int blenderCounter = 0;
    private String firstAtomForBlender = "";
    private String secondAtomForBlender = "";

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
        runningMode.shooterHandler.moveShooter(direction);
        System.out.println("Moving through " + direction);
    }

    public void Rotate(String direction) {
        runningMode.shooterHandler.rotateShooter(direction);
        System.out.println("Rotating through " + direction);
    }

    public void PickAtom() {
        runningMode.shooterHandler.pickAtom();
        System.out.println("Atom changed randomly.");
    }

    public void Shoot() {
        runningMode.shooterHandler.fire();
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

    public void ChooseAtomForBlender(int type) {
        blenderCounter++;
        if (isBlendModeActive) {
            if (blenderCounter == 1) {
                // SET FIRST ATOM
                firstAtomForBlender = "atom " + type;
                isFirstAtomSelected = true;
            } else if (blenderCounter == 2) {
                // SET SECOND ATOM
                secondAtomForBlender = "atom " + type;
                isSecondAtomSelected = true;
            }
        }
        if (isFirstAtomSelected && isSecondAtomSelected) {
            System.out.println("Blend " + firstAtomForBlender + " to\t" + secondAtomForBlender);
            // ATOMS ARE SELECTED. RUN ACTUAL BLEND METHOD ACCORDINGLY
            // BLEND(first, second)

            // THEN RESET BLEND VALUES
            blenderCounter = 0;
            firstAtomForBlender = "";
            secondAtomForBlender = "";
            isSecondAtomSelected = false;
            isSecondAtomSelected = false;
        }
    }
}
