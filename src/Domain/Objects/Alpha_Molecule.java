package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;

public class Alpha_Molecule extends Molecule{

    public MovementofObject movementofObject = MovementType.ZIGZAG.getMovement();
    public Rectangle rectangle;


    public Alpha_Molecule(Position position) {
        super(FinalValues.ALPHA,position);
    }


}
