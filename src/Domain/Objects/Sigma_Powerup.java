package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;

public class Sigma_Powerup extends Powerup{


    public Sigma_Powerup(Position position,boolean isFallable) {
        super(FinalValues.SIGMA, position,isFallable);
        //setMovement(MovementType.STATIONARY.getMovement());
    }

}
