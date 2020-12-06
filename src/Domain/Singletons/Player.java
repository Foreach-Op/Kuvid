package Domain.Singletons;

import Domain.Objects.Shooter;
import Domain.Useful.Health;
import Domain.Useful.Score;

public class Player {
    private static Player player;
    private Health health=new Health();
    private Score score=new Score();

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

    public void setHealth(Health health) {
        this.health = health;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public void getDamage(int a){
        health.updateHealthLevel(a);
    }

    // Method changed according to the score formula.
    public void increaseScore(int current_molecules, int remaining_time){
        score.updateTotalScore(current_molecules,remaining_time);
    }
}
