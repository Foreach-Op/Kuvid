package Domain.Player;

import Domain.Statistics.GameConfiguration;

import java.awt.*;

public class Health {

    //We start from 100 health.

    private double healthLevel = 100;
    private static int game_width = Toolkit.getDefaultToolkit().getScreenSize().width;


    public Health(){}

    //formula for calculating health. Each time a blocker explodes we subtract
    //(game width / distance between blocker and shooter) from the current total health.

    public double updateHealthLevel(double distance){
        healthLevel -= game_width/distance;
        return healthLevel;
    }

    public double getHealthLevel(){
        return this.healthLevel;
    }
}
