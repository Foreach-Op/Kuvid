package Domain.Objects;

import Domain.Utils.FinalValues;
import Domain.Utils.Position;

public class Theta_Shield extends Shield{

    Fireable contextObj;
    private final double boost;
    private static final int speed_reduction_percentage = 9;
    public Theta_Shield(Fireable contextObj) {
        super(contextObj);
        this.contextObj = contextObj;
        boost =0.5+ Math.random()*0.1;
    }
    @Override
    public double getEfficiency() {
        return (1-contextObj.getEfficiency())*boost;
    }
    public Position getVelocity() {
        return new Position(contextObj.getVelocity().getX()*(100-speed_reduction_percentage)/100,
                contextObj.getVelocity().getY()*(100-speed_reduction_percentage)/100);
    }
}
