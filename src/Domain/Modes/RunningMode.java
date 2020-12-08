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

    public RunningMode(ObjectListener frame){
        setFrame(frame);
        frameObjects=new ArrayList<>();
        objectCreationHandler=new ObjectCreationHandler(frameObjects,frame);
        movementHandler=new MovementHandler(frameObjects,frame);
        collisionHandler=new CollisionHandler(frameObjects,frame);
    }

    public void startGame() {
        
    }

    public void moveObjects(){
    }

    public void setFrame(ObjectListener frame){
        this.frame=frame;
    }









}
