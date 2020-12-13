package Domain.Utils;


import Domain.Modes.GameController;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class GameActionHandler extends AbstractAction {

    private String action;
    private GameController gameController;

    public GameActionHandler(String action, GameController gameController) {
        this.action = action;
        this.gameController = gameController;
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
        }
    }
}
