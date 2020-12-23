package Domain.Objects;

import Domain.Utils.FinalValues;
import Domain.Utils.Position;

public class Beta_Atom extends Atom{

    private static double stability = 0.9;

    private static int num_of_protons = 16;

    private int num_of_neutrons; //Number of neutrons is a random integer between {15, 16, 17, 18 21}


    public Beta_Atom(Position position,int angle) {
        super(FinalValues.BETA,position,angle);
        setEfficiency(stability-(0.5*Math.abs(num_of_neutrons-num_of_protons)/num_of_protons));
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
