package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.Position;

public class Beta_Blocker extends Blocker {

    public Beta_Blocker(Position position) {
        super(FinalValues.BETA, position);
    }
}
