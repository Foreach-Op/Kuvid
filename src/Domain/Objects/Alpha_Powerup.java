package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.Position;

public class Alpha_Powerup extends Powerup {


    public Alpha_Powerup(Position position,boolean isFallable) {
        super(FinalValues.ALPHA, position,isFallable);
    }


}
