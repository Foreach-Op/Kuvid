package Domain.TimerBased;


import Domain.ObjectCreator.ObjectFactory;
import Domain.Objects.GameObject;

import java.util.ArrayList;

public class ObjectCreationHandler {

    ArrayList<GameObject> frameObjects;

    public ObjectCreationHandler(ArrayList<GameObject> frameObjects) {
        this.frameObjects=frameObjects;
    }

    public ArrayList<GameObject> createGameObject(String type, String subtype){
        GameObject gameObject=ObjectFactory.getInstance().createObject(type,subtype);
        frameObjects.add(gameObject);
        return frameObjects;
    }
}
