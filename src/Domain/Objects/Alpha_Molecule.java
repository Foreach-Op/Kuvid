package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;

public class Alpha_Molecule extends Molecule{

    MovementType movement = MovementType.ZIGZAG;

    public Alpha_Molecule() {
        super(FinalValues.ALPHA);
    }

    public MovementType getMovementType(){
        return this.movement;
    }
}
