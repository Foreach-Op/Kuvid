package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.Position;





public class Atom extends GameObject {

    /*public Atom(Subtype type) {
        super();
    }*/

    public Atom(String subType, Position position){
        super(FinalValues.ATOM,subType,position);
    }




}
