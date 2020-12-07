package Domain.ObjectCreator;

import Domain.Objects.*;

public class ObjectFactory {

    private static ObjectFactory objectFactory;

    private ObjectFactory(){}

    public static ObjectFactory getInstance(){
        if(objectFactory ==null){
            objectFactory =new ObjectFactory();
        }
        return objectFactory;
    }


    public GameObject createObject(String type,String subtype){
        GameObject gameObject=null;
        switch (type){
            case "Molecule":
                gameObject=new Molecule(subtype);
                break;
            case "Blocker":
                gameObject=new Blocker(subtype);
                break;
            case "Powerup":
                gameObject=new Powerup(subtype);
                break;
            case "Atom":
                gameObject=new Atom(subtype);
                break;
        }
        return gameObject;
    }

}





