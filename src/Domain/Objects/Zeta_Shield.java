package Domain.Objects;

import Domain.Utils.FinalValues;
import Domain.Utils.Position;

public class Zeta_Shield extends Shield{

    Fireable contextObj;
    private final double boost = 0.2;
    private static final int speed_reduction_percentage = 11;
    public Zeta_Shield(Fireable contextObj) {
        super(contextObj);
        this.contextObj = contextObj;
    }
    @Override
    public double getEfficiency() {
        if(contextObj.getNum_of_protons() == contextObj.getNum_of_neutrons()){
            return (1- contextObj.getEfficiency())*boost;
        }
        return contextObj.getEfficiency();
    }
    public Position getVelocity() {
        return new Position(contextObj.getVelocity().getX()*(100-speed_reduction_percentage)/100,
                contextObj.getVelocity().getY()*(100-speed_reduction_percentage)/100);
    }
}
