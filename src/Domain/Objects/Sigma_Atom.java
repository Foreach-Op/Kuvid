package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;

public class Sigma_Atom extends Atom{
    private MovementType movement = MovementType.UPWARDS_STATIONARY;
    public Sigma_Atom() {
        super(FinalValues.SIGMA);
    }
    public MovementType getMovementType(){
        return this.movement;
    }
}
