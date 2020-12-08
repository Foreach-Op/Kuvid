package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;

public class Sigma_Blocker extends Blocker{

    public MovementofObject movementofObject;
    public Rectangle rectangle;

    public Sigma_Blocker(Position position) {
        super(FinalValues.SIGMA,position);
    }
}
