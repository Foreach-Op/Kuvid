package Domain.Objects;

import Domain.Useful.FinalValues;


public class Atom extends GameObject {

    /*public Atom(Subtype type) {
        super();
    }*/

    public Atom(String subType){
        super(FinalValues.ATOM,subType);
    }




}
