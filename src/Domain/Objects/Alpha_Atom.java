package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;

public class Alpha_Atom extends Atom{

    public Rectangle rectangle;

    public Alpha_Atom(Position position) {
        super(FinalValues.ALPHA,position);
    }
}
