package Domain.Objects;

import Domain.Utils.FinalValues;
import Domain.Utils.Position;

public class Beta_Atom extends Atom{

    private static double stability = 0.9;

    private static int num_of_protons = 16;

    private int num_of_neutrons; //Number of neutrons is a random integer between {15, 16, 17, 18 21}


    public Beta_Atom(Position position,int angle) {
        super(FinalValues.BETA,position,angle);
       this.setNum_of_protons(16);
       this.setStability(0.9);
       this.setNum_of_neutrons(15);
    }

    @Override
    public double getEfficiency() {
        return stability-(0.5*Math.abs(num_of_neutrons-num_of_protons)/num_of_protons);
    }
}
