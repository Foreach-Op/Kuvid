package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;

public class Beta_Blocker extends Blocker {

    public Beta_Blocker(Position position) {
        super(FinalValues.BETA, position);
        setMovement(MovementType.QUARTER_STATIONARY_THEN_ZIGZAG.getMovement());
    }
}
