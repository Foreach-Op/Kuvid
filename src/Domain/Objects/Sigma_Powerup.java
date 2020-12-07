package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;

public class Sigma_Powerup extends Powerup{
    private MovementType movement = MovementType.STATIONARY;
    public Sigma_Powerup() {
        super(FinalValues.SIGMA);
    }
    public MovementType getMovementType(){
        return this.movement;
    }
}
