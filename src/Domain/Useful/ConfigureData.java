package Domain.Useful;

import Domain.Objects.*;

import java.io.Serializable;
import java.util.HashMap;

public class ConfigureData implements Serializable {

    //If it is loaded
    private HashMap<GameObject, Position> frameHash=null;
    private Health health=null;
    private Score score=null;
    private int remainingTime=10;
    private Fireable objectInTheTrigger=null;
    //Always
    //If it is saved, these will be updated
    private HashMap<Fireable,Integer> ammunition;
    private HashMap<String,HashMap<String,Integer>> remainingObjects;
    //Even if it is saved, these will be same
    private Difficulty difficulty;
    private int L;
    private HashMap<String,String> alphaType;
    private HashMap<String,String> BetaType;

    public ConfigureData(HashMap<GameObject, Position> frameHash,
                         HashMap<String,HashMap<String,Integer>> remainingObjects,
                         Health health, Score score, int remainingTime,
                         Difficulty difficulty, HashMap<Fireable, Integer> ammunition,
                         Fireable objectInTheTrigger) {
        this.frameHash = frameHash;
        this.remainingObjects = remainingObjects;
        this.health = health;
        this.score = score;
        this.remainingTime = remainingTime;
        this.difficulty = difficulty;
        this.ammunition = ammunition;
        this.objectInTheTrigger = objectInTheTrigger;
    }

    public HashMap<GameObject, Position> getFrameHash() {
        return frameHash;
    }

    public void setFrameHash(HashMap<GameObject, Position> frameHash) {
        this.frameHash = frameHash;
    }

    public HashMap<String,HashMap<String,Integer>> getRemainingObjects() {
        return remainingObjects;
    }

    public void setRemainingObjects(HashMap<String,HashMap<String,Integer>> remainingObjects) {
        this.remainingObjects = remainingObjects;
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

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public HashMap<Fireable, Integer> getAmmunition() {
        return ammunition;
    }

    public void setAmmunition(HashMap<Fireable, Integer> ammunition) {
        this.ammunition = ammunition;
    }

    public Fireable getObjectInTheTrigger() {
        return objectInTheTrigger;
    }

    public void setObjectInTheTrigger(Fireable objectInTheTrigger) {
        this.objectInTheTrigger = objectInTheTrigger;
    }
}
