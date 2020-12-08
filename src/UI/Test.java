package UI;

import Domain.Modes.GameController;
import Domain.Modes.RunningMode;

public class Test {
    public static void main(String[] args) {
        StatisticsWindow statisticsWindow=new StatisticsWindow();
        GameScreen screen=new GameScreen(statisticsWindow);
        RunningMode runningMode=new RunningMode(screen);
        screen.initialize(runningMode);
        //statisticsWindow.initialize()
        GameController gameController=new GameController(runningMode);
        new ConfigureScreen(gameController);
    }
}
