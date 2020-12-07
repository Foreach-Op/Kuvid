package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;

public class Beta_Powerup extends Powerup{
    private MovementType movement = MovementType.STATIONARY;
    public Beta_Powerup() {
        super(FinalValues.BETA);
    }
    public MovementType getMovementType(){
        return this.movement;
    }
}
