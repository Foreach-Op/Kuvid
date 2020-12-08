package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;

public class Gamma_Blocker extends Blocker{

    public MovementofObject movementofObject;
    public Rectangle rectangle;

    public Gamma_Blocker(Position position) {
        super(FinalValues.GAMMA,position);
    }
}