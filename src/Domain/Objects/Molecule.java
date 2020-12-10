package Domain.Objects;


import Domain.Statistics.GameConfiguration;
import Domain.Useful.FinalValues;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;

public class Molecule extends GameObject implements Collectable {


    private final double widthCoef = 0.5;
    private final double heightCoef = 0.5;

    public Molecule(String subType, Position position) {
        super(FinalValues.MOLECULE, subType, position);
        int L= GameConfiguration.getInstance().getData().getL();
        setRectangle(new Rectangle(position, widthCoef*L, heightCoef*L, 0));
    }


    public String[] getCollected() {
        String[] result = new String[2];
        result[0] = FinalValues.ATOM;
        result[1] = this.getSubType();
        return result;
    }
}
