package Domain.Objects;

import Domain.Statistics.GameConfiguration;
import Domain.Utils.FinalValues;
import Domain.Utils.Position;

public class Alpha_Molecule extends Molecule{


    public Alpha_Molecule(Position position) {
        super(FinalValues.ALPHA, position,45);
        setAlphaBetaType(GameConfiguration.getInstance().getData().getAlphaBetaType());
        setHeightWidth();
    }

    private void setHeightWidth() {
        if(getAlphaBetaType().equals("LINEAR")){
            setWidth(2*getL()/3);
            setHeight(getL()/4);
        }
    }
}
