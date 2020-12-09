package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;

public class Gamma_Atom extends Atom{

    public MovementofObject movementofObject;
    public Rectangle rectangle;


    public Gamma_Atom(int angle) {
        super(FinalValues.GAMMA,angle);
    }
}
