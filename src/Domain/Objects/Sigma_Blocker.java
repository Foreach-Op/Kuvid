package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;

public class Sigma_Blocker extends Blocker{

    public MovementofObject movementofObject = MovementType.STATIONARY.getMovement();
    public Rectangle rectangle;

    public Sigma_Blocker(Position position) {
        super(FinalValues.SIGMA,position);
    }
}
