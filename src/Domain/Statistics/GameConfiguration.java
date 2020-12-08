package Domain.Statistics;

import java.util.HashMap;

public class GameConfiguration {
    private static GameConfiguration gameConfiguration;
    private GameData data;
    private StaticWindowListener staticWindowListener;

    private GameConfiguration(){}

    public static GameConfiguration getInstance(){
        if(gameConfiguration==null){
            gameConfiguration=new GameConfiguration();
        }
        return gameConfiguration;
    }

    public void setStaticWindowListener(StaticWindowListener staticWindowListener){
        this.staticWindowListener=staticWindowListener;
    }

    public GameData getData() {
        return this.data;
    }

    public void setData(GameData data) {
        this.data = data;
    }

    public void setTime(double time){
        data.setRemainingTime(time);
        staticWindowListener.onTimeChange(time);
    }

    public void setScore(double score){
        data.setScore(score);
        staticWindowListener.onScoreChange(score);
    }

    public void setHealth(int health){
        data.setHealth(health);
        staticWindowListener.onHealthChange(health);
    }

    public void setAmmunition(HashMap<String,HashMap<String,Integer>> ammo){
        data.setAmmunition(ammo);
        staticWindowListener.onAmmunitionChange(ammo);
    }

}
