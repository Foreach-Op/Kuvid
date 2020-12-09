package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;

public class Gamma_Blocker extends Blocker{

    public MovementofObject movementofObject = MovementType.HALF_STATIONARY_THEN_ZIGZAG.getMovement();
    public Rectangle rectangle;

    public Gamma_Blocker(Position position) {
        super(FinalValues.GAMMA, position);
    }
}
