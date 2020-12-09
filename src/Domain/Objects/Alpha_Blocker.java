package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;

public class Alpha_Blocker extends Blocker{



    public Alpha_Blocker(Position position) {
        super(FinalValues.ALPHA, position);
        setMovement( MovementType.ZIGZAG.getMovement());
    }
}
