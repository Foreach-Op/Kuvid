package Domain.Objects;

import Domain.Utils.FinalValues;
import Domain.Utils.Position;

public class Sigma_Atom extends Atom {

    public Sigma_Atom(Position position,int angle) {
        super(FinalValues.SIGMA,position,angle);
    }

}
