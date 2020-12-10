package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;

public class Beta_Powerup extends Powerup {


    public Beta_Powerup(Position position,boolean isFallable) {
        super(FinalValues.BETA, position,isFallable);
    }

}
