package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;

public class Beta_Powerup extends Powerup{

    public MovementofObject movementofObject = MovementType.STATIONARY.getMovement();
    public Rectangle rectangle;

    private MovementType movement = MovementType.STATIONARY;
    public Beta_Powerup(Position position) {
        super(FinalValues.BETA,position);
    }
    public MovementType getMovementType(){
        return this.movement;
    }
}
