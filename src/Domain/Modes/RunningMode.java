package Domain.Modes;


import Domain.Objects.GameObject;
import Domain.Objects.ObjectListener;
import Domain.Statistics.GameConfiguration;
import Domain.TimerBased.CollisionHandler;
import Domain.TimerBased.MovementHandler;
import Domain.TimerBased.ObjectCreationHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;



public class RunningMode {

    private ObjectListener frameListener;

    private ArrayList<GameObject> frameObjects;

    private HashMap<String,HashMap<String,Integer>> objectsToBeProduced=new HashMap<>();
    private HashMap<String,HashMap<String,Integer>> ammunition=new HashMap<>();

    CollisionHandler collisionHandler;
    MovementHandler movementHandler;
    ObjectCreationHandler objectCreationHandler;

    private int refreshRate;

    public RunningMode(ObjectListener frameListener){
        setFrameListener(frameListener);
        frameObjects=new ArrayList<>();
        objectCreationHandler=new ObjectCreationHandler(frameObjects,frameListener);
        movementHandler=new MovementHandler(frameObjects,frameListener);
        collisionHandler=new CollisionHandler(frameObjects,frameListener);
    }

    public void startGame() {

        Timer timer = CreateObject();
        refreshRate=10;
        Timer timer2 = moveandCollide();

    }

    public void setFrameListener(ObjectListener frameListener){
        this.frameListener =frameListener;
    }

    private Timer moveandCollide() {
        Timer timer = new Timer(refreshRate, e -> {
            movementHandler.move();
            collisionHandler.collisionDetect();
        });
        timer.start();
        return timer;
    }


    private Timer CreateObject() {

        int time= setCreationTime();
        Timer timer = new Timer(time, e -> {
            //ObjectCreation Randomizer needed
            //objectCreationHandler.createGameObject("Atom","Alpha");
        });

        timer.start();
        return timer;
    }

    private int setCreationTime() {
        int time=0;
        switch (GameConfiguration.getInstance().getData().getDifficulty()){
            case HARD:
                time=250;
                break;
            case NORMAL:
                time=500;
                break;
            case EASY:
                time=1000;
                break;
        }
        return time;
    }

}
