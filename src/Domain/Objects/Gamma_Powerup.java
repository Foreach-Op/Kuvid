package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;

public class Gamma_Powerup extends Powerup {


    public Gamma_Powerup(Position position) {
        super(FinalValues.GAMMA, position);
        setMovement(MovementType.STATIONARY.getMovement());
    }

    public Gamma_Powerup() {
        super(FinalValues.GAMMA);
    }


}
