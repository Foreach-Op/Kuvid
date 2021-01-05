package Domain.Player;

import Domain.UserFunctionalities.GameStatueControl;
import Domain.Statistics.GameConfiguration;

public class Player {
    private static Player player;
    GameConfiguration gameConfiuration=GameConfiguration.getInstance();
    private Health health=new Health(gameConfiuration.getData().getHealth());
    private Score score=new Score(gameConfiuration.getData().getScore());
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
        gameConfiuration.setHealth(healthLevel);
    }

    public double getScore() {
        return score.getTotalScore();
    }

    public void setScore(double score) {
        this.score.setTotalScore(score);
        gameConfiuration.setScore(score);
    }

    public void hit(int distance){
        health.updateHealthLevel(distance);
        gameConfiuration.setHealth(health.getHealthLevel());
        if(health.getHealthLevel()<=0){
            GameStatueControl.getInstance().setGameEnded();
        }
    }

    public void increaseScore(double efficiency, double remaining_time_on_frame){
        score.updateTotalScore(efficiency,remaining_time_on_frame);
        gameConfiuration.setScore(score.getTotalScore());
    }
}
