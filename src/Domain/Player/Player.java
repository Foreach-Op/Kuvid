package Domain.Player;

import Domain.Functionalities.GameStatueControl;

public class Player {
    private static Player player;
    private final Health health=new Health();
    private final Score score=new Score();

    private Player(){}

    public static Player getInstance(){
        if(player==null){
            player=new Player();
        }
        return player;
    }

    public Health getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health.setHealthLevel(health);
    }

    public double getScore() {
        return score.getTotalScore();
    }

    public void setScore(double score) {
        this.score.setTotalScore(score);
    }

    public void hit(int distance){
        health.updateHealthLevel(distance);
        if(health.getHealthLevel()<=0){
            GameStatueControl.getInstance().setGameEnded();
        }
    }

    // Method changed according to the score formula.
    public void increaseScore(int current_molecules, int remaining_time){
        score.updateTotalScore(current_molecules,remaining_time);
    }
}
