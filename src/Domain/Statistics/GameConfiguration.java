package Domain.Statistics;

import Domain.ShooterFunctions.Shooter;

import java.util.HashMap;

public class GameConfiguration {
    private static GameConfiguration gameConfiguration;
    private GameData data;
    private StaticWindowListener staticWindowListener;
    private Shooter shooter;
    private GameConfiguration(){}

    public static GameConfiguration getInstance(){
        if(gameConfiguration==null){
            gameConfiguration=new GameConfiguration();
        }
        return gameConfiguration;
    }

    public Shooter getShooter() {
        return shooter;
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
        //data.getPlayer().setScore(score);
        //data.setScore(score);
        staticWindowListener.onScoreChange(score);
    }

    public void setHealth(double health){
        //data.getPlayer().setHealth(health);
        //data.setHealth(health);
        staticWindowListener.onHealthChange(health);
    }

    public void setAmmunition(HashMap<String,HashMap<String,Integer>> ammo){
        data.setAmmunition(ammo);
        staticWindowListener.onAmmunitionChange(ammo);
    }

    public void setRemainingObjects(String type,String subtype){
        getData().getRemainingObjects().get(type).replace(subtype,getData().getRemainingObjects().get(type).get(subtype)-1);
    }

    public HashMap<String, HashMap<String, Integer>> getRemainingObjects(){
        return getData().getRemainingObjects();
    }


}
