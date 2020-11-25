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

    public HashMap<Fallable,ObjectListener> createFallableObject(String object,String subtype){
        Fallable fallable=null;
        ObjectListener objPanel=null;
        switch (object){
            case "Molecule":
                fallable=new Molecule(subtype);
                objPanel=new ObjectPanel("Molecule",subtype,new Position());
                objPanel.initialize((GameObject) fallable);
                break;
            case "Blocker":
                fallable=new Blocker(subtype);
                break;
            case "Powerup":
                fallable=new Powerup(subtype);
                break;
        }
        HashMap<Fallable,ObjectListener> map=new HashMap<>();
        map.put(fallable,objPanel);
        return map;
    }
}
