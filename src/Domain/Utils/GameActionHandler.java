package Domain.Utils;

import Domain.DomainControl.GameController;
import UI.PauseWindow;
import UI.UIController;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class GameActionHandler extends AbstractAction {

    private String action;
    private GameController gameController;
    private UIController uiController;

    public GameActionHandler(String action, GameController gameController) {
        this.action = action;
        this.gameController = gameController;
        uiController = UIController.GetInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (action) {
            case "move left":
                gameController.Move("left");
                break;
            case "move right":
                gameController.Move("right");
                break;
            case "rotate left":
                gameController.Rotate("left");
                break;
            case "rotate right":
                gameController.Rotate("right");
                break;
            case "pick atom":
                gameController.PickAtom();
                break;
            case "fire":
                gameController.Shoot();
                break;
            case "pause":
                gameController.Pause();
                if (gameController.isGamePaused())
                    uiController.openPauseWindow();
                break;
            case "resume":
                gameController.Resume();
                break;
            case "blend":
                gameController.Blend();
                break;
            case "atom 1":
                gameController.ChooseAtomForBlender("Alpha");
                break;
            case "atom 2":
                gameController.ChooseAtomForBlender("Beta");
                break;
            case "atom 3":
                gameController.ChooseAtomForBlender("Gamma");
                break;
            case "atom 4":
                gameController.ChooseAtomForBlender("Sigma");
                break;
            case "choose powerup 1":
                gameController.PickPowerup("Alpha");
                break;
            case "choose powerup 2":
                gameController.PickPowerup("Beta");
                break;
            case "choose powerup 3":
                gameController.PickPowerup("Gamma");
                break;
            case "choose powerup 4":
                gameController.PickPowerup("Sigma");
                break;
            case "eta shield":
                gameController.addShield(FinalValues.ETA);
                break;
            case "lota shield":
                gameController.addShield(FinalValues.LOTA);
                break;
            case "theta shield":
                gameController.addShield(FinalValues.THETA);
                break;
            case "zeta shield":
                gameController.addShield(FinalValues.ZETA);
                break;
        }
    }

    public void PerformAction(){
        switch (action){
            case "resume":
                gameController.Resume();
                break;
            case "choose powerup 1":
                gameController.PickPowerup("Alpha");
                break;
            case "choose powerup 2":
                gameController.PickPowerup("Beta");
                break;
            case "choose powerup 3":
                gameController.PickPowerup("Gamma");
                break;
            case "choose powerup 4":
                gameController.PickPowerup("Sigma");
                break;
            case "eta shield":
                gameController.addShield(FinalValues.ETA);
                break;
            case "lota shield":
                gameController.addShield(FinalValues.LOTA);
                break;
            case "theta shield":
                gameController.addShield(FinalValues.THETA);
                break;
            case "zeta shield":
                gameController.addShield(FinalValues.ZETA);
                break;
        }
    }
}
