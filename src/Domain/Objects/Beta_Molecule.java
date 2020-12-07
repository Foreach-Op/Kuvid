package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;

public class Beta_Molecule extends Molecule{
    MovementType movement = MovementType.QUARTER_STATIONARY_THEN_ZIGZAG;
    public Beta_Molecule() {
        super(FinalValues.BETA);
    }
    public MovementType getMovementType(){
        return this.movement;
    }
}
