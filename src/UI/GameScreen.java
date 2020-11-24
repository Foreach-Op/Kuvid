package UI;

import javax.swing.*;

public class GameScreen extends JFrame {

    private static GameScreen gamescreen;

    private GameScreen(){}

    public static GameScreen getInstance(){
        if(gamescreen ==null){
            gamescreen =new GameScreen();
        }
        return gamescreen;
    }


    public void addObjectPanel(ObjectPanel objectPanel) {
        this.add(objectPanel);
    }
}
