package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.Position;

public class Blocker extends GameObject{

    public Blocker(String subType, Position position) {
        super(FinalValues.BLOCKER,subType,position);
    }

}
