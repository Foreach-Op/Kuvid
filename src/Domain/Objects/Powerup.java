package Domain.Objects;

import Domain.Modes.RunningMode;
import Domain.Useful.FinalValues;
import Domain.Useful.MovementType;
import Domain.Useful.Position;
import Domain.Statistics.GameConfiguration;
import Domain.Useful.Rectangle;

import java.util.HashMap;

import static Domain.Statistics.GameData.L;

public class Powerup extends GameObject{
    private int angle;
    private final double widthCoef = 1;
    private final double heightCoef = 1;

    private boolean isFallable;

    public Powerup(String subType, Position position,boolean isFallable) {
        super(FinalValues.POWERUP, subType, position);
        this.isFallable=isFallable;
        int L=GameConfiguration.getInstance().getData().getL();
        int angle;
        if(!isFallable){
            angle = GameConfiguration.getInstance().getShooter().getAngle();
            setMovement(new MovementofObject((int) (-L / Math.tan(angle)),
                    (int) L, 0));
        } else{
            setMovement(MovementType.STATIONARY.getMovement());
        }
        setRectangle(new Rectangle(position, widthCoef*L, heightCoef*L, 0));

    }

    public boolean isFallable() {
        return isFallable;
    }

    public void setFallable(boolean fallable) {
        isFallable = fallable;
    }


}
