package Domain.Modes;


import Domain.Objects.GameObject;
import Domain.TimerBased.CollisionHandler;
import Domain.TimerBased.MovementHandler;
import Domain.TimerBased.ObjectCreationHandler;
import UI.ObjectPanel;

import java.util.ArrayList;
import java.util.HashMap;

public class RunningMode {

    private ArrayList<GameObject> frameObjects;

    private HashMap<String,HashMap<String,Integer>> fallableMap=new HashMap<>();
    private HashMap<String,HashMap<String,Integer>> fireableMap=new HashMap<>();

    CollisionHandler collisionHandler;
    MovementHandler movementHandler;
    ObjectCreationHandler objectCreationHandler;

    public RunningMode(){
        frameObjects=new ArrayList<>();
        objectCreationHandler=new ObjectCreationHandler(frameObjects);
        movementHandler=new MovementHandler(frameObjects);
        collisionHandler=new CollisionHandler(frameObjects);
    }

    public void startGame() {
        
    }

    public void moveObjects(){
    }









}
