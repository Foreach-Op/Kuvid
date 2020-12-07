package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;

public class Gamma_Atom extends Atom{
    private MovementType movement = MovementType.UPWARDS_STATIONARY;
    public Gamma_Atom() {
        super(FinalValues.GAMMA);
    }
    public MovementType getMovementType(){
        return this.movement;
    }
}
