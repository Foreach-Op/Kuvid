package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;

public class Gamma_Powerup extends Powerup{

    public MovementofObject movementofObject;
    public Rectangle rectangle;

    private MovementType movement = MovementType.STATIONARY;
    public Gamma_Powerup(Position position) {
        super(FinalValues.GAMMA,position);
    }
    public MovementType getMovementType(){
        return this.movement;
    }
}
