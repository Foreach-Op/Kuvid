package Domain.Objects;

import Domain.Utils.FinalValues;
import Domain.Utils.Position;

public class Sigma_Atom extends Atom {

    private static double stability = 0.7;

    private static int num_of_protons = 64;

    private int num_of_neutrons; //Number of neutrons is a random integer between {63, 64, 67}

    public Sigma_Atom(Position position,int angle) {
        super(FinalValues.SIGMA,position,angle);
        this.setNum_of_protons(64);
        this.setStability(0.7);
        this.setNum_of_neutrons(63);
    }

    @Override
    public double getEfficiency() {
        return (1 + stability)/ 2 + (Math.abs(num_of_neutrons-num_of_protons)/num_of_protons);
    }
}
