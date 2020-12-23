package Domain.Objects;

import Domain.Utils.FinalValues;
import Domain.Utils.Position;

public class Alpha_Atom extends Atom {

    private static double stability = 0.85;

    private static int num_of_protons = 8;

    private int num_of_neutrons; //Number of neutrons is a random integer between {7, 8, 9}

    public Alpha_Atom(Position position,int angle) {
        super(FinalValues.ALPHA,position,angle);
        setEfficiency((1-(Math.abs(num_of_neutrons-num_of_protons)/num_of_protons))*stability);
    }

    public static double getStability() {
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
