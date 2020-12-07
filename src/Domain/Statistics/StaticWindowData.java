package Domain.Statistics;

import java.util.HashMap;

public class StaticWindowData {
    private int health;
    private int score;
    private double time;
    private HashMap<String, HashMap<String, Integer>> ammunition;

    public StaticWindowData(int health, int score, double time) {
        this.health = health;
        this.score = score;
        this.time = time;
        ammunition=new HashMap<>();
    }

    public void addAmmunition(String type, String subtype,int amount){
        HashMap<String,Integer> map=ammunition.get(type);
        map.put(subtype,map.get(subtype)+amount);
    }

    public int getHealth() {
        return health;
    }

    public int getScore() {
        return score;
    }

    public double getTime() {
        return time;
    }

    public HashMap<String, HashMap<String, Integer>> getAmmunition() {
        return ammunition;
    }
}
