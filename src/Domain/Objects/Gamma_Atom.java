package Domain.Objects;

import Domain.Utils.FinalValues;
import Domain.Utils.Position;

public class Gamma_Atom extends Atom {

    private static double stability = 0.8;

    private static int num_of_protons = 32;

    private int num_of_neutrons; //Number of neutrons is a random integer between {29, 32, 33}

    public Gamma_Atom(Position position,int angle) {
        super(FinalValues.GAMMA,position,angle);
        this.setStability(0.8);
        this.setNum_of_protons(32);
        this.setNum_of_neutrons(29);
    }

    @Override
    public double getEfficiency() {
        return stability + (Math.abs(num_of_neutrons-num_of_protons)/(2*num_of_protons));
    }
}
