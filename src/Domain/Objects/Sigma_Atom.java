package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;

public class Sigma_Atom extends Atom{

    public MovementofObject movementofObject;
    public Rectangle rectangle;


    public Sigma_Atom(Position position) {
        super(FinalValues.SIGMA,position);
    }

}
