package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;

public class Beta_Molecule extends Molecule {

    public Beta_Molecule(Position position) {
        super(FinalValues.BETA, position);
        this.setMovement(MovementType.QUARTER_STATIONARY_THEN_ZIGZAG.getMovement());
    }

}
