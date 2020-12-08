package Domain.ObjectCreator;

import Domain.Objects.*;
import Domain.Useful.FinalValues;
import Domain.Useful.Position;

public class ObjectFactory {

    private static ObjectFactory objectFactory;

    private ObjectFactory(){}

    public static ObjectFactory getInstance(){
        if(objectFactory ==null){
            objectFactory =new ObjectFactory();
        }
        return objectFactory;
    }


    public GameObject createObject(String type, String subtype, Position position){

        switch (type){
            case FinalValues.MOLECULE:
                return MoleculeFactory.getInstance().createMolecule(subtype,position);
            case FinalValues.BLOCKER:
                return BlockerFactory.getInstance().createBlocker(subtype,position);
            case FinalValues.POWERUP:
                return PowerupFactory.getInstance().createPowerup(subtype,position);
            default:
               return AtomFactory.getInstance().createAtom(subtype,position);
        }

    }

}





