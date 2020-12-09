package Domain.Statistics;

import Domain.Objects.*;
import Domain.Useful.Difficulty;
import Domain.Useful.MovementType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class GameData implements Serializable {

    //If it is loaded
    private ArrayList<GameObject> frameObjects = null;
    private double health = 100;
    private double score = 0;
    private double remainingTime = 10.00;
    private GameObject objectInTheTrigger = null;
    private HashMap<String, HashMap<String, Integer>> powerUps=null;
    public static int screenHeight = 100;
    public static int screenWidth=100;
    //Always
    //If it is saved, these will be updated
    private boolean isLoaded = false;
    private HashMap<String, HashMap<String, Integer>> ammunition;
    private HashMap<String, HashMap<String, Integer>> remainingObjects;
    //Even if it is saved, these will be same
    private Difficulty difficulty;
    public static int L;/////// make it visible
    private String alphaBetaType;
    private MovementType alphaBetaMovementType;


    public GameData(){}

    public GameData(boolean isLoaded, HashMap<String, HashMap<String, Integer>> ammunition,
                    HashMap<String, HashMap<String, Integer>> remainingObjects,
                    Difficulty difficulty, int l, String alphaBetaType,
                    MovementType alphaBetaMovementType) {
        this.isLoaded = isLoaded;
        this.ammunition = ammunition;
        this.remainingObjects = remainingObjects;
        this.difficulty = difficulty;
        L = l;
        this.alphaBetaType = alphaBetaType;
        this.alphaBetaMovementType = alphaBetaMovementType;
    }

    public GameData(ArrayList<GameObject> frameObjects, double health,
                    double score, double remainingTime, GameObject objectInTheTrigger,
                    HashMap<String, HashMap<String, Integer>> powerUps, boolean isLoaded,
                    HashMap<String, HashMap<String, Integer>> ammunition,
                    HashMap<String, HashMap<String, Integer>> remainingObjects,
                    Difficulty difficulty, int l, String alphaBetaType,
                    MovementType alphaBetaMovementType) {
        this.frameObjects = frameObjects;
        this.health = health;
        this.score = score;
        this.remainingTime = remainingTime;
        this.objectInTheTrigger = objectInTheTrigger;
        this.powerUps = powerUps;
        this.isLoaded = isLoaded;
        this.ammunition = ammunition;
        this.remainingObjects = remainingObjects;
        this.difficulty = difficulty;
        L = l;
        this.alphaBetaType = alphaBetaType;
        this.alphaBetaMovementType = alphaBetaMovementType;
    }

    public ArrayList<GameObject> getFrameObjects() {
        return frameObjects;
    }

    public void setFrameObjects(ArrayList<GameObject> frameObjects) {
        this.frameObjects = frameObjects;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(double remainingTime) {
        this.remainingTime = remainingTime;
    }

    public GameObject getObjectInTheTrigger() {
        return objectInTheTrigger;
    }

    public void setObjectInTheTrigger(GameObject objectInTheTrigger) {
        this.objectInTheTrigger = objectInTheTrigger;
    }

    public HashMap<String, HashMap<String, Integer>> getPowerUps() {
        return powerUps;
    }

    public void setPowerUps(HashMap<String, HashMap<String, Integer>> powerUps) {
        this.powerUps = powerUps;
    }

    public boolean isLoaded() {
        return isLoaded;
    }

    public void setLoaded(boolean loaded) {
        isLoaded = loaded;
    }

    public HashMap<String, HashMap<String, Integer>> getAmmunition() {
        return ammunition;
    }

    public void setAmmunition(HashMap<String, HashMap<String, Integer>> ammunition) {
        this.ammunition = ammunition;
    }

    public HashMap<String, HashMap<String, Integer>> getRemainingObjects() {
        return remainingObjects;
    }

    public void setRemainingObjects(HashMap<String, HashMap<String, Integer>> remainingObjects) {
        this.remainingObjects = remainingObjects;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public int getL() {
        return L;
    }

    public void setL(int l) {
        L = l;
    }

    public String getAlphaBetaType() {
        return alphaBetaType;
    }

    public void setAlphaBetaType(String alphaBetaType) {
        this.alphaBetaType = alphaBetaType;
    }

    public MovementType getAlphaBetaMovementType() {
        return alphaBetaMovementType;
    }

    public void setAlphaBetaMovementType(MovementType alphaBetaMovementType) {
        this.alphaBetaMovementType = alphaBetaMovementType;
    }
}
