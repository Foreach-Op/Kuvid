package Domain.TimerBased;


import Domain.Listeners.ObjectListener;
import Domain.ObjectCreator.ObjectFactory;
import Domain.Objects.GameObject;

import java.util.ArrayList;

public class ObjectCreationHandler {

    private final ArrayList<GameObject> frameObjects;
    private final ObjectListener frame;

    public ObjectCreationHandler(ArrayList<GameObject> frameObjects,ObjectListener frame) {
        this.frameObjects=frameObjects;
        this.frame=frame;
    }

    public void createGameObject(String type, String subtype){
        GameObject gameObject=ObjectFactory.getInstance().createObject(type,subtype);
        frameObjects.add(gameObject);
        frame.onCreate(gameObject);
    }
}
