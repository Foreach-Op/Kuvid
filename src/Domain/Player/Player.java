package Domain.Player;

import Domain.Functionalities.GameStatueControl;
import Domain.Statistics.GameConfiguration;

public class Player {
    private static Player player;
    private Health health=new Health(100.00);
    private Score score=new Score(0.00);
    //private String playerName;

    private Player(){}

    public static Player getInstance(){
        if(player==null){
            player=new Player();
        }
        return player;
    }

    public double getHealth() {
        return health.getHealthLevel();
    }

    public void setHealth(double healthLevel) {
        this.health.setHealthLevel(healthLevel);
        GameConfiguration.getInstance().setHealth(healthLevel);
    }

    public double getScore() {
        return score.getTotalScore();
    }

    public void setScore(double score) {
        this.score.setTotalScore(score);
        GameConfiguration.getInstance().setScore(score);
    }

    public void hit(int distance){
        health.updateHealthLevel(distance);
        GameConfiguration.getInstance().setHealth(health.getHealthLevel());
        if(health.getHealthLevel()<=0){
            GameStatueControl.getInstance().setGameEnded();
        }
    }

    // Method changed according to the score formula.
    public void increaseScore(double efficiency, double remaining_time_on_frame){
        score.updateTotalScore(efficiency,remaining_time_on_frame);
        GameConfiguration.getInstance().setScore(score.getTotalScore());
    }
}
