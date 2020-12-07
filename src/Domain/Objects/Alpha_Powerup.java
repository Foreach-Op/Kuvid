package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;

public class Alpha_Powerup extends Powerup{
    private MovementType movement = MovementType.STATIONARY;

    public Alpha_Powerup() {
        super(FinalValues.ALPHA);
    }

    public MovementType getMovementType(){
        return this.movement;
    }
}
