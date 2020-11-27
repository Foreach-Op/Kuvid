package Domain.Factories;

import Domain.Listeners.ObjectListener;
import Domain.Objects.*;
import UI.ObjectPanel;

import java.util.HashMap;

public class ObjectFactory {

    private static ObjectFactory objectFactory;

    private ObjectFactory(){}

    public static ObjectFactory getInstance(){
        if(objectFactory ==null){
            objectFactory =new ObjectFactory();
        }
        return objectFactory;
    }

    public HashMap<GameObject, ObjectListener> createObject(String object){
        HashMap<GameObject, ObjectListener> ObjectMap;
        ObjectMap=createObject(object,"","");
        return ObjectMap;
    }


    public HashMap<GameObject, ObjectListener> createObject(String object, String type){
        HashMap<GameObject, ObjectListener> ObjectMap;
        if(object.equals("Atom")){
            ObjectMap=createObject(object,type,"Fireable");
        } else {
            ObjectMap=createObject(object,type,"Fallable");
        }

        return ObjectMap;

    }


    public HashMap<GameObject, ObjectListener> createObject(String object, String type, String property){
        HashMap<GameObject, ObjectListener> ObjectMap;
        switch (object){
            case "Powerup":
                if(property.equals("Fallable")){
                    ObjectMap = FallableFactory.getInstance().createFallableObject(object,type);
                } else {
                    ObjectMap = FireableFactory.getInstance().createFireableObject(object,type);
                }
                break;
            case "Atom":
                ObjectMap = FireableFactory.getInstance().createFireableObject(object,type);
                break;
            default:
                ObjectMap = FallableFactory.getInstance().createFallableObject(object,type);
        }
        return ObjectMap;
    }




}
