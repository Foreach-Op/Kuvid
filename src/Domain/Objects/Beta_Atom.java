package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;

public class Beta_Atom extends Atom{

    private MovementType movement = MovementType.UPWARDS_STATIONARY;
    public Beta_Atom() {
        super(FinalValues.BETA);
    }
    public MovementType getMovementType(){
        return this.movement;
    }
}
