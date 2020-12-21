package Domain.Objects;

import Domain.Utils.FinalValues;

public class Lota_Shield extends Shield{


    private static final int speed_reduction_percentage = 7;
    public Lota_Shield(String subType) {
        super(FinalValues.LOTA);
    }
    public static int getSpeed_reduction_percentage() {
        return speed_reduction_percentage;
    }
    @Override
    public void improve_efficiency(Atom atom) {
        super.improve_efficiency(atom);
    }
}
