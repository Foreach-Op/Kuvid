package Domain.Objects;

import Domain.Utils.FinalValues;

public class Zeta_Shield extends Shield{


    private static final int speed_reduction_percentage = 11;
    public Zeta_Shield(String subType) {
        super(FinalValues.ZETA);
    }
    public static int getSpeed_reduction_percentage() {
        return speed_reduction_percentage;
    }
    @Override
    public void improve_efficiency(Atom atom) {
        super.improve_efficiency(atom);
    }
}
