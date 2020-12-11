package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.Position;

public class Sigma_Blocker extends Blocker{


    public Sigma_Blocker(Position position) {
        super(FinalValues.SIGMA, position);
    }
}
