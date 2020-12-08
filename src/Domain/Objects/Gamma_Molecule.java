package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;

public class Gamma_Molecule extends Molecule{

    public MovementofObject movementofObject;
    public Rectangle rectangle;
    MovementType movement = MovementType.HALF_STATIONARY_THEN_ZIGZAG;
    public Gamma_Molecule(Position position) {
        super(FinalValues.GAMMA,position);
    }
    public MovementType getMovementType(){
        return this.movement;
    }
}
