package Domain.Objects;

import Domain.Statistics.GameConfiguration;
import Domain.Useful.FinalValues;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;

public class Blocker extends GameObject {
    private final double heightCoef = 1;
    private final double widthCoef = 1;

    public Blocker(String subType, Position position) {
        super(FinalValues.BLOCKER, subType, position,90);
        int L= GameConfiguration.getInstance().getData().getL();
        //setRectangle(new Rectangle(position, widthCoef*L, heightCoef*L, 0));
    }

}
