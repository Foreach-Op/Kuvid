package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;

public class Gamma_Powerup extends Powerup{
    private MovementType movement = MovementType.STATIONARY;
    public Gamma_Powerup() {
        super(FinalValues.GAMMA);
    }
    public MovementType getMovementType(){
        return this.movement;
    }
}
