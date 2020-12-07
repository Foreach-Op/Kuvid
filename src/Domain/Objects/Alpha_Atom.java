package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;

public class Alpha_Atom extends Atom{
    private MovementType movement = MovementType.UPWARDS_STATIONARY;
    public Alpha_Atom() {
        super(FinalValues.ALPHA);
    }
    public MovementType getMovementType(){
        return this.movement;
    }
}
