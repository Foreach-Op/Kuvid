package Domain.Objects;

import Domain.Utils.FinalValues;

public class Theta_Shield extends Shield{


    private static final int speed_reduction_percentage = 9;
    public Theta_Shield(String subType) {
        super(FinalValues.THETA);
    }
    public static int getSpeed_reduction_percentage() {
        return speed_reduction_percentage;
    }
    @Override
    public void improve_efficiency(Atom atom) {
        super.improve_efficiency(atom);
    }
}
