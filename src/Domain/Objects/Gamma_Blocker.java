package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;

public class Gamma_Blocker extends Blocker {


    public Gamma_Blocker(Position position) {
        super(FinalValues.GAMMA, position);
        setMovement(MovementType.HALF_STATIONARY_THEN_ZIGZAG.getMovement());
    }
}
