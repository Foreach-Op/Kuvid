package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;

public class Beta_Blocker extends Blocker{

    public MovementofObject movementofObject;
    public Rectangle rectangle;

    public Beta_Blocker(Position position) {
        super(FinalValues.BETA,position);
    }
}
