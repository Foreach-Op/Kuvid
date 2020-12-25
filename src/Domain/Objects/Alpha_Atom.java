package Domain.Objects;

import Domain.Utils.FinalValues;
import Domain.Utils.Position;

public class Alpha_Atom extends Atom {

    private static double stability = 0.85;

    private static int num_of_protons = 8;

    private int num_of_neutrons; //Number of neutrons is a random integer between {7, 8, 9}

    public Alpha_Atom(Position position,int angle) {
        super(FinalValues.ALPHA,position,angle);
       this.setNum_of_protons(8);
       this.setStability(0.85);
       this.setNum_of_neutrons(7);
    }

    @Override
    public double getEfficiency() {
        return (1-(Math.abs(num_of_neutrons-num_of_protons)/num_of_protons))*stability;
    }
}
