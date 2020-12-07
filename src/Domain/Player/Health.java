package Domain.Player;

public class Health {

    //We start from 100 health.

    private double healthLevel = 100;
    private static int game_width;


    public Health(){}

    //formula for calculating health. Each time a blocker explodes we subtract
    //(game width / distance between blocker and shooter) from the current total health.
    public void updateHealthLevel(double distance){
        healthLevel -= game_width/distance;
    }

    // Unnecessary at the moment
    /*
    public void setHealthLevel(int healthLevel) {
        this.healthLevel = healthLevel;
    }*/
    public void setHealthLevel(int healthLevel){
        this.healthLevel=healthLevel;
    }
    public double getHealthLevel(){
        return this.healthLevel;
    }
}
