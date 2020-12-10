package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;

public class Gamma_Powerup extends Powerup {


    public Gamma_Powerup(Position position,boolean isFallable) {
        super(FinalValues.GAMMA, position,isFallable);
        //setMovement(MovementType.STATIONARY.getMovement());
    }


}
