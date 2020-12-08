package Domain.Modes;


import Domain.Listeners.ObjectListener;
import Domain.Objects.GameObject;
import Domain.TimerBased.CollisionHandler;
import Domain.TimerBased.MovementHandler;
import Domain.TimerBased.ObjectCreationHandler;
import Domain.Useful.GameData;

import java.util.ArrayList;
import java.util.HashMap;

public class RunningMode {

    private ObjectListener frame;

    private ArrayList<GameObject> frameObjects;

    private HashMap<String,HashMap<String,Integer>> objectsToBeProduced=new HashMap<>();
    private HashMap<String,HashMap<String,Integer>> ammunition=new HashMap<>();

    CollisionHandler collisionHandler;
    MovementHandler movementHandler;
    ObjectCreationHandler objectCreationHandler;

    public RunningMode(GameData data){
        frameObjects=data.getFrameObjects();
    }

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
