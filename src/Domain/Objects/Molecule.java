package Domain.Objects;


import Domain.Statistics.GameConfiguration;
import Domain.Useful.FinalValues;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;

public class Molecule extends GameObject{


    private final double widthCoef = 0.5;
    private final double heightCoef = 0.5;

    public Molecule(String subType, Position position,int angle) {
        super(FinalValues.MOLECULE, subType, position,angle);
        int L=10; //for test purpose
        //int L= GameConfiguration.getInstance().getData().getL();
        //setRectangle(new Rectangle(position, widthCoef*L, heightCoef*L, angle));
    }

}
