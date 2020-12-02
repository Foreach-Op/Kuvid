package Domain.Factories;

import Application.Modes.RunningMode;
import Domain.Listeners.ObjectListener;
import Domain.Objects.*;
import UI.ObjectPanel;

import java.util.HashMap;

public class FallableFactory {
    private static FallableFactory fallableFactory;

    private FallableFactory(){}

    public static FallableFactory getInstance(){
        if(fallableFactory ==null){
            fallableFactory =new FallableFactory();
        }
        return fallableFactory;
    }

 /* public HashMap<GameObject,ObjectListener> createFallableObject(String object,String subtype){
        Fallable fallable=null;
        ObjectListener objPanel=null;
        HashMap<GameObject,ObjectListener> map=new HashMap<>();
        switch (object){
            case "Molecule":
                fallable=new Molecule(subtype);
                objPanel=new ObjectPanel("Molecule",subtype,new Position());
                objPanel.initialize((GameObject) fallable);
                break;
            case "Blocker":
                fallable=new Blocker(subtype);
                objPanel=new ObjectPanel("Blocker",subtype,new Position());
                objPanel.initialize((GameObject) fallable);
                break;
            case "Powerup":
                fallable=new Powerup(subtype);
                objPanel=new ObjectPanel("Powerup",subtype,new Position());
                objPanel.initialize((GameObject) fallable);
                break;
        }
        map.put((GameObject) fallable,objPanel);
        return map;
    }*/
}
