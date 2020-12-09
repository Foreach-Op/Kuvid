package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;

public class Beta_Atom extends Atom{

    public MovementofObject movementofObject;
    public Rectangle rectangle;


    public Beta_Atom(int angle) {
        super(FinalValues.BETA,angle);
    }

}
