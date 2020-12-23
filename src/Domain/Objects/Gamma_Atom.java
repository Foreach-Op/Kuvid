package Domain.Objects;

import Domain.Utils.FinalValues;
import Domain.Utils.Position;

public class Gamma_Atom extends Atom {

    private static double stability = 0.8;

    private static int num_of_protons = 32;

    private int num_of_neutrons; //Number of neutrons is a random integer between {29, 32, 33}

    public Gamma_Atom(Position position,int angle) {
        super(FinalValues.GAMMA,position,angle);
        setEfficiency(stability + (Math.abs(num_of_neutrons-num_of_protons)/(2*num_of_protons)));
    }

    public double getStability() {
        return stability;
    }
    public static int getNum_of_protons() {
        return num_of_protons;
    }
    public int getNum_of_neutrons() {
        return num_of_neutrons;
    }

    public void setNum_of_neutrons(int num_of_neutrons) {
        this.num_of_neutrons = num_of_neutrons;
    }
}
