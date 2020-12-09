package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;

public class Sigma_Powerup extends Powerup{

    public Sigma_Powerup(Position position ) {
        super(FinalValues.SIGMA, position);
        setMovement(MovementType.STATIONARY.getMovement());
    }
    public Sigma_Powerup() {
        super(FinalValues.SIGMA);
    }

}
