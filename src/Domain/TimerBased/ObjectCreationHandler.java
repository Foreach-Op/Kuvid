package Domain.TimerBased;


import Domain.Objects.ObjectListener;
import Domain.ObjectCreator.ObjectFactory;
import Domain.Objects.GameObject;
import Domain.Statistics.GameConfiguration;
import Domain.Useful.FinalValues;
import Domain.Useful.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class ObjectCreationHandler {

    private final CopyOnWriteArrayList<GameObject> frameObjects;
    private final ObjectListener frame;
    private final HashMap<String, HashMap<String, Integer>> remainingObjects;
    private final int L;
    //private final int gamescreenheight;
    private final int gamescreenwidth;

    public ObjectCreationHandler(CopyOnWriteArrayList<GameObject> frameObjects, ObjectListener frame) {
        this.frameObjects=frameObjects;
        this.frame=frame;
        L=GameConfiguration.getInstance().getData().getL();
        gamescreenwidth=GameConfiguration.getInstance().getData().getGameScreenWidth();
        remainingObjects=GameConfiguration.getInstance().getRemainingObjects();

    }


    public GameObject createRandomFallingObject(){

        String type=null;
        String subtype=null;
        while (subtype == null) {
            type = getRandomType();
            subtype = getRandomSubType(type,subtype,remainingObjects);
        }
        GameConfiguration.getInstance().setRemainingObjects(type,subtype);
        return createGameObject(type,subtype, randomInitialPosition());
    }

    public GameObject createGameObject(String type, String subtype, Position position){
        return createGameObject(type,subtype,position,true);
    }

    public GameObject createGameObject(String type,String subtype,Position position,boolean isFallable){
        GameObject gameObject=ObjectFactory.getInstance().createObject(type,subtype, position,isFallable);
        frameObjects.add(gameObject);
        frame.onCreate(gameObject);
        return gameObject;
    }

    private String getRandomType() {

        int random = (int) (Math.random() * 3);
        if (random == 0) { return FinalValues.MOLECULE; }
        else if (random == 1){return FinalValues.BLOCKER;}
        else {return FinalValues.POWERUP;}
    }

    private String getRandomSubType(String type,String subtype,HashMap<String, HashMap<String, Integer>> remainingObjects) {

        int random = (int) (Math.random() * 4);
        if (random == 0) {if (remainingObjects.get(type).get(FinalValues.ALPHA) > 0) subtype = FinalValues.ALPHA;}
        else if (random == 1){ if(remainingObjects.get(type).get(FinalValues.BETA)>0) subtype =FinalValues.BETA;}
        else if (random == 2){ if(remainingObjects.get(type).get(FinalValues.GAMMA)>0) subtype =FinalValues.GAMMA;}
        else {if(remainingObjects.get(type).get(FinalValues.SIGMA)>0) subtype =FinalValues.SIGMA;}

        return subtype;
    }

    private Position randomInitialPosition(){
        //int y=-L;
        int y=20; //test purpose
        int x= (new Random()).nextInt(gamescreenwidth*4/5-L);

        return new Position(x,y); /// randomize position
    }


}
