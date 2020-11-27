package Domain.Factories;

import Domain.Listeners.ObjectListener;
import Domain.Objects.*;
import UI.ObjectPanel;

import java.util.HashMap;

public class FireableFactory {
    private static FireableFactory fireableFactory;

    private FireableFactory(){}

    public static FireableFactory getInstance(){
        if(fireableFactory ==null){
            fireableFactory =new FireableFactory();
        }
        return fireableFactory;
    }

    public HashMap<GameObject, ObjectListener> createFireableObject(String object, String type){
        Fireable fireable=null;
        ObjectListener objPanel=null;
        HashMap<GameObject,ObjectListener> map=new HashMap<>();
        switch (object){
            case "Atom":
                fireable=new Atom(type);
                objPanel=new ObjectPanel("Atom",type,new Position());
                objPanel.initialize((GameObject) fireable);
                break;
            case "Powerup":
                fireable=new Powerup(type);
                objPanel=new ObjectPanel("Powerup",type,new Position());
                objPanel.initialize((GameObject) fireable);
                break;
        }
        map.put((GameObject) fireable,objPanel);
        return map;
    }
}
