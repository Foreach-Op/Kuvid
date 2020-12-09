package Domain.Useful;


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
                gameController.ChooseAtomForBlender(1);
                break;
            case "atom 2":
                gameController.ChooseAtomForBlender(2);
                break;
            case "atom 3":
                gameController.ChooseAtomForBlender(3);
                break;
            case "atom 4":
                gameController.ChooseAtomForBlender(4);
                break;
        }
    }
}