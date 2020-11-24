package Domain.Factories;

import Domain.Objects.*;

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
        switch (object){
            case "Molecule":
                fallable=new Molecule(type);
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
