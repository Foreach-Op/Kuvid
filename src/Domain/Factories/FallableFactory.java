package Domain.Factories;

import Domain.Listeners.ObjectListener;
import Domain.Objects.*;
import UI.ObjectPanel;

public class FallableFactory {
    private static FallableFactory fallableFactory;

    private FallableFactory(){}

    public static FallableFactory getInstance(){
        if(fallableFactory ==null){
            fallableFactory =new FallableFactory();
        }
        return fallableFactory;
    }

    public Fallable getFallableObject(String object,String type){
        Fallable fallable=null;
        ObjectListener objPanel;
        switch (object){
            case "Molecule":
                fallable=new Molecule(type);
                objPanel=new ObjectPanel(type,new Position());
                objPanel.initialize((GameObject) fallable);
                break;
            case "Blocker":
                fallable=new Blocker(type);
                break;
            case "Powerup":
                fallable=new Powerup(type);
                break;
        }
        return fallable;
    }
}
