package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;

public class Gamma_Molecule extends Molecule{
    MovementType movement = MovementType.HALF_STATIONARY_THEN_ZIGZAG;
    public Gamma_Molecule() {
        super(FinalValues.GAMMA);
    }
    public MovementType getMovementType(){
        return this.movement;
    }
}
