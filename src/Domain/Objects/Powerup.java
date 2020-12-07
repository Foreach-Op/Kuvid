package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.Subtype;

import java.util.HashMap;

public class Powerup extends GameObject{
    /*
    public Powerup(Subtype type) {
        super();
    }
     */

    public Powerup(String subType){
        super(FinalValues.POWERUP,subType);
    }


}
