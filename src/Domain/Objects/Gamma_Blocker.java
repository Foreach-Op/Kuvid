package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.Position;

public class Gamma_Blocker extends Blocker {


    public Gamma_Blocker(Position position) {
        super(FinalValues.GAMMA, position);
    }
}
