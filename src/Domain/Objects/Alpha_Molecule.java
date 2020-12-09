package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;

public class Alpha_Molecule extends Molecule{



    public Alpha_Molecule(Position position) {
        super(FinalValues.ALPHA, position);
        this.setMovement(MovementType.ZIGZAG.getMovement());
    }


}
