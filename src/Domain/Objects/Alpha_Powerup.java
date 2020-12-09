package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;

public class Alpha_Powerup extends Powerup{

    public MovementofObject movementofObject = MovementType.STATIONARY.getMovement();
    public Rectangle rectangle;

    private MovementType movement = MovementType.STATIONARY;

    public Alpha_Powerup(Position position) {
        super(FinalValues.ALPHA, position);
    }
    public Alpha_Powerup(int angle) {
        super(FinalValues.ALPHA, angle);
    }

    public MovementType getMovementType(){
        return this.movement;
    }
}
