package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.Position;

public class Sigma_Atom extends Atom {

    public Sigma_Atom(Position position,int angle) {
        super(FinalValues.SIGMA,position,angle);
    }

}
