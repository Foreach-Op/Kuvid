package Domain.ObjectCreation;


import Domain.Objects.ObjectListener;
import Domain.Objects.GameObject;
import Domain.Statistics.GameConfiguration;
import Domain.Statistics.GameData;
import Domain.Utils.FinalValues;
import Domain.Utils.Position;

import java.util.*;

public class ObjectCreationHandler {

    private final ArrayList<GameObject> frameObjects;
    private final ObjectListener frame;
    private final HashMap<String, HashMap<String, Integer>> remainingObjects;
    private final int L;
    //private final int gamescreenheight;
    private final int gameScreenWidth;
    private ObjectFactory objectFactory;


    public void initiateFrame(){
        GameData gameData=GameConfiguration.getInstance().getData();
        ArrayList<String[]> frame= gameData.getObjectsOnFrame();
        if (frame!=null){
            for (int i = 1; i < frame.size(); i++) {
                String[] info= frame.get(i);
                String type=info[0];
                String subtype=info[1];
                double xPos=Double.parseDouble(info[2]);
                double yPos=Double.parseDouble(info[3]);
                boolean isFallable=Boolean.parseBoolean(info[4]);
                Position position=new Position(xPos,yPos);
                createGameObject(type,subtype,position,isFallable);
            }
        }
    }

    public ObjectCreationHandler(ArrayList<GameObject> frameObjects, ObjectListener frame) {
        GameData gameData=GameConfiguration.getInstance().getData();
        this.frameObjects=frameObjects;
        this.frame=frame;
        this.objectFactory=ObjectFactory.getInstance();
        this.remainingObjects=gameData.getRemainingObjects();
        L=gameData.getL();
        gameScreenWidth =gameData.getGameScreenWidth();
        initiateFrame();
    }


    public GameObject createRandomFallingObject(){

        String type=null;
        String subtype=null;
        while (subtype == null) {
            type = getRandomType();
            subtype = getRandomSubType(type,subtype,remainingObjects);
        }

        remainingObjects.get(type).replace(subtype,remainingObjects.get(type).get(subtype)-1);
        return createGameObject(type,subtype, randomInitialPosition());
    }

    public GameObject createGameObject(String type, String subtype, Position position){
        return createGameObject(type,subtype,position,true);
    }

    public GameObject createGameObject(String type,String subtype,Position position,boolean isFallable){
        GameObject gameObject=objectFactory.createObject(type,subtype, position,isFallable);
        createGameObject(gameObject);
        return gameObject;
    }

    public GameObject createGameObject(GameObject gameObject){
        frameObjects.add(gameObject);
        frame.onCreate(gameObject);
        return gameObject;
    }

    private String getRandomType() {

        int random=(int) (Math.random() * 130);
        if (random<100){
            return FinalValues.MOLECULE;
        }
        else if(random<110 && random>=100) {
            return FinalValues.BLOCKER;
        } else {
            return FinalValues.POWERUP;
        }
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
        int y=-L;
        //int y=20; //test purpose
        int x= (new Random()).nextInt(gameScreenWidth *4/5-L);

        return new Position(x,y); /// randomize position
    }



    /*
    private class RemindTask extends TimerTask {

        GameObject gameObject;
        public RemindTask(GameObject gameObject) {
            this.gameObject=gameObject;
        }

        @Override
        public void run() {
            gameObject.setCollectible(true);
        }
    }

     */
}
