package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.Position;


import java.util.HashMap;

public class Powerup extends GameObject implements Collectable{
    /*
    public Powerup(Subtype type) {
        super();
    }
     */

    public Powerup(String subType, Position position){
        super(FinalValues.POWERUP,subType,position);
    }


    @Override
    public String[] getCollected() {
        String[] result = new String[2];
        result[0] = this.getType();
        result[1] = this.getSubType();
        return result;
    }
}
