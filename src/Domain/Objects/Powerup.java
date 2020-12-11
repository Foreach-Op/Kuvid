package Domain.Objects;

import Domain.Useful.FinalValues;
import Domain.Useful.Position;
import Domain.Statistics.GameConfiguration;

public class Powerup extends GameObject{


    public Powerup(String subType, Position position,boolean isFallable) {
        super(FinalValues.POWERUP, subType, position,90,isFallable);
        setWidth(getL()/2);
        setHeight(getL());

        if(!isFallable){
            setAngle(GameConfiguration.getInstance().getShooter().getAngle());
            setVelocityY(-getVelocityY());
        }
        //setRectangle(new Rectangle(position, widthCoef*L, heightCoef*L, 0));
    }

    public boolean isFallable() {
        return isFallable();
    }

    //public void setFallable(boolean fallable) {
      //  isFallable = fallable;
    //}


}
