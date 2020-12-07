package Domain.ObjectCreator;

import Domain.Objects.*;
import Domain.Useful.FinalValues;

public class AtomFactory {
    private static AtomFactory atomFactory;

    private AtomFactory(){}

    public static AtomFactory getInstance(){
        if(atomFactory ==null) atomFactory =new AtomFactory();

        return atomFactory;
    }


    public GameObject createAtom(String subtype) {

        switch (subtype) {
            case FinalValues.ALPHA:
                return new Alpha_Atom();

            case FinalValues.BETA:
                return new Beta_Atom();

            case FinalValues.GAMMA:
                return new Gamma_Atom();

            default:
                return new Sigma_Atom();

        }


    }
}
