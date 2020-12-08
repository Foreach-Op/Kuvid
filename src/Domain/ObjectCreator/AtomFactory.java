package Domain.ObjectCreator;

import Domain.Objects.*;
import Domain.Useful.FinalValues;
import Domain.Useful.Position;

public class AtomFactory {
    private static AtomFactory atomFactory;

    private AtomFactory(){}

    public static AtomFactory getInstance(){
        if(atomFactory ==null) atomFactory =new AtomFactory();

        return atomFactory;
    }


    public GameObject createAtom(String subtype, Position position) {

        switch (subtype) {
            case FinalValues.ALPHA:
                return new Alpha_Atom(position);

            case FinalValues.BETA:
                return new Beta_Atom(position);

            case FinalValues.GAMMA:
                return new Gamma_Atom(position);

            default:
                return new Sigma_Atom(position);

        }


    }
}
