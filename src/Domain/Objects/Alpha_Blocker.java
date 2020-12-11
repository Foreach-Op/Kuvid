package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.Position;

public class Alpha_Blocker extends Blocker{

    public Alpha_Blocker(Position position) {
        super(FinalValues.ALPHA, position);
    }
}
