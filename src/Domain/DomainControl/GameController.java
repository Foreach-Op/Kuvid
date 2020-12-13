package Domain.DomainControl;

import Domain.Blend.Blender;
import Domain.Functionalities.GameStatueControl;

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
        if(!GameStatueControl.getInstance().isGamePaused()) {
            runningMode.shooterHandler.moveShooter(direction);
            System.out.println("Moving through " + direction);
        }
    }

    public void Rotate(String direction) {
        if(!GameStatueControl.getInstance().isGamePaused()) {
            runningMode.shooterHandler.rotateShooter(direction);
            System.out.println("Rotating through " + direction);
        }
    }

    public void PickAtom() {
        if(!GameStatueControl.getInstance().isGamePaused()) {
            runningMode.shooterHandler.changeBullet();
            System.out.println("Atom changed randomly.");
        }
    }

    public void PickPowerup(String subtype){
        if(!GameStatueControl.getInstance().isGamePaused()) {
            runningMode.shooterHandler.changeBulletToPowerup(subtype);
            System.out.println("Bullet changed to selected powerup:" + subtype);
        }
    }

    public void Shoot() {
        if(!GameStatueControl.getInstance().isGamePaused()) {
            runningMode.shooterHandler.fire(runningMode.objectCreationHandler);
            System.out.println("SHOOT");
        }
    }

    public void Blend() {
        if(!GameStatueControl.getInstance().isGamePaused()) {
            if (isBlendModeActive) {
                isBlendModeActive = false;
            } else {
                isBlendModeActive = true;
            }
            System.out.println("Blend Mode: " + isBlendModeActive);
        }
    }

    public void Pause() {
        if(!GameStatueControl.getInstance().isGamePaused()){
            System.out.println("pause");
            runningMode.pauseGame();
        }
    }

    public void Resume() {
        if(GameStatueControl.getInstance().isGamePaused()){
            System.out.println("resume");
            runningMode.resumeGame();
        }
    }

    public void ChooseAtomForBlender(String type) {
        if(!GameStatueControl.getInstance().isGamePaused()) {
            System.out.println("Here");
            blenderCounter++;
            if (isBlendModeActive) {
                if (blenderCounter == 1) {
                    // SET FIRST ATOM
                    firstAtomForBlender = type;
                    isFirstAtomSelected = true;
                } else if (blenderCounter == 2) {
                    // SET SECOND ATOM
                    secondAtomForBlender = type;
                    isSecondAtomSelected = true;
                }
            }
            if (isFirstAtomSelected && isSecondAtomSelected) {
                System.out.println("Blend " + firstAtomForBlender + " to\t" + secondAtomForBlender);
                // ATOMS ARE SELECTED. RUN ACTUAL BLEND METHOD ACCORDINGLY
                // BLEND(first, second)
                Blender blender = new Blender();
                blender.Transform(firstAtomForBlender, secondAtomForBlender);
                // THEN RESET BLEND VALUES
                blenderCounter = 0;
                firstAtomForBlender = "";
                secondAtomForBlender = "";
                isSecondAtomSelected = false;
                isSecondAtomSelected = false;
            }
        }
    }
}
