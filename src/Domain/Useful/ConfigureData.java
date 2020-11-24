package Domain.Useful;

import Domain.Objects.Fallable;
import Domain.Objects.Fireable;
import Domain.Objects.GameObject;
import Domain.Objects.Position;

import java.io.Serializable;
import java.util.HashMap;

public class ConfigureData implements Serializable {
    private HashMap<GameObject, Position> frameHash;
    private HashMap<String,HashMap<String,Integer>> remainingObjects;
    private Health health;
    private Score score;
    private int remainingTime;
    private Difficulty difficulty;
    private HashMap<Fireable,Integer> ammunition;
    private Fireable objectInTheTrigger;

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
