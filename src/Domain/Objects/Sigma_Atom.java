package Domain.Objects;

import Domain.Utils.FinalValues;
import Domain.Utils.Position;

public class Sigma_Atom extends Atom {

    private static double stability = 0.7;

    private static int num_of_protons = 64;

    private int num_of_neutrons; //Number of neutrons is a random integer between {63, 64, 67}

    private double efficiency = (1 + stability)/ 2 + (Math.abs(num_of_neutrons-num_of_protons)/num_of_protons);

    public Sigma_Atom(Position position,int angle) {
        super(FinalValues.SIGMA,position,angle);
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
    public double getEfficiency() {
        return efficiency;
    }
    public void setEfficiency(double efficiency) {
        this.efficiency = efficiency;
    }
}
