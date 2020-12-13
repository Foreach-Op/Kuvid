package Domain.ObjectCreator;

import Domain.Objects.*;
import Domain.Utils.FinalValues;
import Domain.Utils.Position;

public class ObjectFactory {

    private static ObjectFactory objectFactory;

    private ObjectFactory(){}

    public static ObjectFactory getInstance(){
        if(objectFactory ==null){
            objectFactory =new ObjectFactory();
        }
        return objectFactory;
    }


    public GameObject createObject(String type, String subtype, Position position,boolean isFallable){

        switch (type){
            case FinalValues.MOLECULE:
                return MoleculeFactory.getInstance().createMolecule(subtype, position);
            case FinalValues.BLOCKER:
                return BlockerFactory.getInstance().createBlocker(subtype, position);
            case FinalValues.ATOM:
                return AtomFactory.getInstance().createAtom(subtype,position,90);
            default:
                return PowerupFactory.getInstance().createPowerup(subtype, position,isFallable);
        }

    }

}





