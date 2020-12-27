package Domain.DomainControl;

import Domain.Blend.Blender;
import Domain.ShooterFunctions.ShooterHandler;
import Domain.UserFunctionalities.GameStatueControl;

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
    private final GameStatueControl statueControl;
    private long lastTimeShoot=0;
    private final int FIRE_RATE=2000;

    public GameController(RunningMode runningMode) {
        this.runningMode = runningMode;
        buildingMode = new BuildingMode();
        statueControl=GameStatueControl.getInstance();
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
        if(!statueControl.isGamePaused()) {
            runningMode.shooterHandler.moveShooter(direction);
        }
    }

    public void Rotate(String direction) {
        if(!statueControl.isGamePaused()) {
            runningMode.shooterHandler.rotateShooter(direction);
        }
    }

    public void PickAtom() {
        if(!statueControl.isGamePaused()) {
            runningMode.shooterHandler.changeBullet();
        }
    }

    public void PickPowerup(String subtype){
        if(!statueControl.isGamePaused()) {
            runningMode.shooterHandler.changeBulletToPowerup(subtype);
        }
    }

    public void Shoot() {
        if(!statueControl.isGamePaused()&&(System.currentTimeMillis()-lastTimeShoot)>=FIRE_RATE) {
            runningMode.shooterHandler.fire(runningMode.objectCreationHandler);
            lastTimeShoot=System.currentTimeMillis();
        }
    }

    public void Blend() {
        if(!statueControl.isGamePaused()) {
            if (isBlendModeActive) {
                isBlendModeActive = false;
            } else {
                isBlendModeActive = true;
            }
        }
    }

    public void Pause() {
        if(!statueControl.isGamePaused()){
            runningMode.pauseGame();
        }
    }

    public void Resume() {
        if(statueControl.isGamePaused()){
            runningMode.resumeGame();
        }
    }

    public void ChooseAtomForBlender(String type) {
        if(!statueControl.isGamePaused()) {
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
                Blender blender = new Blender();
                blender.Transform(firstAtomForBlender, secondAtomForBlender);

                // RESET BLEND VALUES
                blenderCounter = 0;
                firstAtomForBlender = "";
                secondAtomForBlender = "";
                isSecondAtomSelected = false;
                isSecondAtomSelected = false;
            }
        }
    }

    public boolean isGamePaused(){
        return statueControl.isGamePaused();
    }


    public void addShield(String shieldtype){
        runningMode.shooterHandler.addShield(shieldtype);
    }
}
