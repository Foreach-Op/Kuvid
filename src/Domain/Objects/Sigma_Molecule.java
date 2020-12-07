package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;

public class Sigma_Molecule extends Molecule{

    private MovementType movement = MovementType.STATIONARY;

    public Sigma_Molecule() {
        super(FinalValues.SIGMA);
    }

    public MovementType getMovementType(){
        return this.movement;
    }
}
