package Domain.Statistics;

import Domain.Objects.*;
import Domain.Player.Player;
import Domain.ShooterFunctions.Shooter;
import Domain.Utils.Difficulty;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class GameData implements Serializable {

    private ArrayList<GameObject> frameObjects = null;
    private ArrayList<GameObject> shieldedAtoms = null;
    private double health;
    private double score;

    private double remainingTime;
    private GameObject objectInTheTrigger = null;

    private boolean isLoaded = false;
    private HashMap<String, HashMap<String, Integer>> ammunition;
    private HashMap<String, HashMap<String, Integer>> remainingObjects;
    private HashMap<String,Integer> remainingShield;

    private Difficulty difficulty;
    public static int L;
    private String alphaBetaType;
    private String movementType;

    private int gameScreenWidth;
    private int gameScreenHeight;

    public Shooter shooter;

    public GameData(){}

    public GameData(boolean isLoaded, HashMap<String, HashMap<String, Integer>> ammunition,
                    HashMap<String, HashMap<String, Integer>> remainingObjects,
                    Difficulty difficulty, int l, String alphaBetaType) {
        this.isLoaded = isLoaded;
        this.ammunition = ammunition;
        this.remainingObjects = remainingObjects;
        this.difficulty = difficulty;
        setL(l);
        this.alphaBetaType = alphaBetaType;
    }

    public GameData(ArrayList<GameObject> frameObjects, double health,
                    double score, double remainingTime, GameObject objectInTheTrigger, boolean isLoaded,
                    HashMap<String, HashMap<String, Integer>> ammunition,
                    HashMap<String, HashMap<String, Integer>> remainingObjects,
                    Difficulty difficulty, int l, String alphaBetaType) {
        this.frameObjects = frameObjects;
        this.health = health;
        this.score = score;
        this.remainingTime = remainingTime;
        this.objectInTheTrigger = objectInTheTrigger;
        this.isLoaded = isLoaded;
        this.ammunition = ammunition;
        this.remainingObjects = remainingObjects;
        this.difficulty = difficulty;
        setL(l);
        this.alphaBetaType = alphaBetaType;
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
        L=(gameScreenHeight*l)/100;
    }

    public String getAlphaBetaType() {
        return alphaBetaType;
    }

    public void setAlphaBetaType(String alphaBetaType) {
        this.alphaBetaType = alphaBetaType;
    }

    public int getGameScreenWidth(){
        return gameScreenWidth;
    }

    public void setGameScreenWidth(int gameScreenWidth){
        this.gameScreenWidth = gameScreenWidth;
    }

    public int getGameScreenHeight(){
        return gameScreenHeight;
    }

    public void setGameScreenHeight(int gameScreenHeight){
        this.gameScreenHeight = gameScreenHeight;
    }

    public String getMovementType() {
        return movementType;
    }

    public void setMovementType(String movementType) {
        this.movementType = movementType;
    }

    public Shooter getShooter() {
        return shooter;
    }

    public void setShooter(Shooter shooter) {
        this.shooter = shooter;
    }

    public HashMap<String, Integer> getRemainingShield() {
        return remainingShield;
    }

    public void setRemainingShield(HashMap<String, Integer> remainingShield) {
        this.remainingShield = remainingShield;
    }

    public ArrayList<GameObject> getShieldedAtoms() {
        return shieldedAtoms;
    }

    public void setShieldedAtoms(ArrayList<GameObject> shieldedAtoms) {
        this.shieldedAtoms = shieldedAtoms;
    }
}
