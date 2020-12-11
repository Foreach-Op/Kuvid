package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.Position;

public class Gamma_Powerup extends Powerup {


    public Gamma_Powerup(Position position,boolean isFallable) {
        super(FinalValues.GAMMA, position,isFallable);
    }


}
